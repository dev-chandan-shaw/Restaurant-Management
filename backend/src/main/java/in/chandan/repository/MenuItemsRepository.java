package in.chandan.repository;

import in.chandan.entity.MenuItems;
import in.chandan.entity.MenuTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {

}
