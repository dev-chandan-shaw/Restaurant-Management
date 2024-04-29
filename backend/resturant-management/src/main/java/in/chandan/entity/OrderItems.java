package in.chandan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItems {

    private Long id;
    @ManyToOne
    @JoinColumn(name = "menu_item", referencedColumnName = "id")
    private MenuItems menuItem;
    private int quantity;

    public MenuItems getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItems menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
