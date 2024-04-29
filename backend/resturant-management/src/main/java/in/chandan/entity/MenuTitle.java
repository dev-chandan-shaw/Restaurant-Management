package in.chandan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MenuTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    @OneToMany(mappedBy = "menuTitle", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuItems> menuItemsList;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<MenuItems> getMenuItemsList() {
        return menuItemsList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMenuItemsList(List<MenuItems> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }
}
