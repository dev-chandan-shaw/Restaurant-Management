package in.chandan.controller;

import in.chandan.entity.MenuItems;
import in.chandan.entity.OrderItems;
import in.chandan.entity.UserInfo;
import in.chandan.repository.MenuItemsRepository;
import in.chandan.repository.OrderItemsRepository;
import in.chandan.repository.OrdersRepository;
import in.chandan.repository.UserInfoRepository;
import in.chandan.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("http://localhost:5173")
public class OrderController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;


    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/order-item")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @CachePut(cacheNames = "order-items", key = "#menuItem.id")
    public String addOrderItem(@RequestBody MenuItems menuItem, Principal principal) {
        String userEmail = principal.getName();
        UserInfo user = userInfoService.getCurrentUser(userEmail);
        OrderItems orderItem = new OrderItems();
        orderItem.setMenuItem(menuItem);
        orderItem.setQuantity(1);
        orderItem.setOrder(user.getOrders());
        orderItemsRepository.save(orderItem);
        return "Item added Successfully";
    }




    @GetMapping("/order-items")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getOrderItems(Principal principal) {
        UserInfo user = userInfoRepository.findByEmail(principal.getName()).orElseThrow();
        return ResponseEntity.ok(user.getOrders().getOrderItemsList());
    }

    @DeleteMapping("/order-items/{orderItemId}")
    public ResponseEntity<?> removeOrderItem(@PathVariable Long orderItemId) {
        try {
            orderItemsRepository.deleteById(orderItemId);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception error) {
            throw error;
        }
    }


}
