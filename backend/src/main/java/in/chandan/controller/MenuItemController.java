package in.chandan.controller;

import in.chandan.entity.MenuItems;
import in.chandan.repository.MenuItemsRepository;
import in.chandan.repository.MenuTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class MenuItemController {

    @Autowired
    private MenuItemsRepository repository;

    @Autowired
    private MenuTitleRepository menuTitleRepository;

    @PostMapping("/menu-items")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addMenuItems(@RequestBody MenuItems item) {
        System.out.println(item.getName());
        repository.save(item);
        return "Menu Item added successfully";
    }


}
