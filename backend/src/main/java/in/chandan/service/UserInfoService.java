package in.chandan.service;


import in.chandan.entity.Orders;
import in.chandan.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import in.chandan.entity.UserInfo;
import in.chandan.entity.UserInfoDetails;
import in.chandan.repository.UserInfoRepository;

import java.util.Optional; 

@Service
@EnableCaching
public class UserInfoService implements UserDetailsService { 

	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	private UserInfoRepository repository; 

	@Autowired
	private PasswordEncoder encoder; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 

		Optional<UserInfo> userDetail = repository.findByEmail(username);

		// Converting userDetail to UserDetails 
		return userDetail.map(UserInfoDetails::new) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	} 

	public void addUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		Orders orders = new Orders();
		ordersRepository.save(orders);
		userInfo.setOrders(orders);
		userInfo.setRoles("ROLE_USER");
		repository.save(userInfo);
	}

	@Cacheable(cacheNames = "user", key = "#email")
	public UserInfo getCurrentUser(String email) {
		return repository.findByEmail(email).get();
	}

} 

