package in.chandan.repository;

import in.chandan.entity.MenuItems;
import in.chandan.entity.MenuTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuTitleRepository extends JpaRepository<MenuTitle,Long> {
    MenuTitle findByTitleContaining(String title);
}
