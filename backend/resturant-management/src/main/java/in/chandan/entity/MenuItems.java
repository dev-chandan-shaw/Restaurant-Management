package in.chandan.entity;

import jakarta.persistence.*;

@Entity
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String imageUrl;
    @ManyToOne
    @JoinColumn
    private MenuTitle menuTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MenuTitle getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(MenuTitle menuTitle) {
        this.menuTitle = menuTitle;
    }
}
