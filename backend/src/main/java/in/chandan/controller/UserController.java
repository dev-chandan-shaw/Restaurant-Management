package in.chandan.controller;
import in.chandan.entity.Orders;
import in.chandan.repository.OrdersRepository;
import in.chandan.repository.UserInfoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import in.chandan.entity.UserInfo;
import in.chandan.service.JwtService;
import in.chandan.service.UserInfoService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/auth") 
public class UserController { 

	@Autowired
	private UserInfoService service; 

	@Autowired
	private JwtService jwtService; 

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@GetMapping("/welcome") 
	public List<UserInfo> welcome() {
		return userInfoRepository.findAll();
	} 

	@PostMapping("/signup")
	public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo) {
		System.out.println("my first name is : " + userInfo.getFirstName());

		if (userInfoRepository.findByEmail(userInfo.getEmail()).isPresent()) {
			return ResponseEntity.badRequest().body("User already exist. Try login..");
		}
		service.addUser(userInfo);
		return ResponseEntity.ok("User registered successfully.");
	} 

	@GetMapping("/user/userProfile") 
	@PreAuthorize("hasAuthority('ROLE_USER')") 
	public String userProfile() { 
		return "Welcome to User Profile"; 
	} 

	@GetMapping("/admin/adminProfile") 
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	public String adminProfile() { 
		return "Welcome to Admin Profile"; 
	} 

	@PostMapping("/login")
	public Map<String, Object> authenticateAndGetToken(@RequestBody UserInfo authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {

			UserInfo user = userInfoRepository.findByEmail(authRequest.getEmail()).orElseThrow();
			String token = jwtService.generateToken(user.getEmail(), authentication.getAuthorities());
			System.out.println(user.getFirstName());
			return Map.of("token", token, "name", user.getFirstName());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}


} 
