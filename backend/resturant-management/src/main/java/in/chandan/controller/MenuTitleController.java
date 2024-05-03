package in.chandan.controller;

import in.chandan.entity.MenuItems;
import in.chandan.entity.MenuTitle;
import in.chandan.repository.MenuTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class MenuTitleController {
    @Autowired
    private MenuTitleRepository menuTitleRepository;

    @PostMapping("/menu-titles")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addMenuTitle(@RequestBody MenuTitle menuTitle, Principal principal) {
        menuTitleRepository.save(menuTitle);
        return ResponseEntity.ok("Menu Title added successfully");
    }

    @GetMapping("/menu-titles")
    public ResponseEntity<?> getAllMenuTitle(Principal principal){
        return ResponseEntity.ok(menuTitleRepository.findAll());
    }

    @GetMapping("/{title}/menu-items")
    public List<MenuItems> getAllMenuItems(@PathVariable Long title){
        MenuTitle menuTitle = menuTitleRepository.findById(title).orElseThrow();
        return menuTitle.getMenuItemsList();
    }
}
