package in.chandan.controller;

import in.chandan.entity.MenuItems;
import in.chandan.entity.OrderItems;
import in.chandan.entity.UserInfo;
import in.chandan.entity.UserInfoDetails;
import in.chandan.repository.MenuItemsRepository;
import in.chandan.repository.OrderItemsRepository;
import in.chandan.repository.OrdersRepository;
import in.chandan.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class OrderController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    MenuItemsRepository menuItemsRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @PostMapping("/{menuItemId}/order-item")
    public String addOrderItem(@PathVariable String menuItemId, Principal principal) {
        System.out.println("My user id is : " + menuItemId);
//        UserInfo user = userInfoRepository.findByEmail(principal.getName()).orElseThrow();
//        MenuItems menuItem = menuItemsRepository.findById(menuItemId).orElseThrow();
//        System.out.println("My menu item is :  " + menuItem.getName());
//        OrderItems orderItem = new OrderItems();
//        orderItem.setMenuItem(menuItem);
//        orderItem.setQuantity(1);
//        orderItemsRepository.save(orderItem);
//        List<OrderItems> list = user.getOrders().getOrderItemsList();
//        list.add(orderItem);
//        user.getOrders().setOrderItemsList(list);

//        ordersRepository.save(user.getOrders());

        return "user is authenticated and can add this item";
    }
}
