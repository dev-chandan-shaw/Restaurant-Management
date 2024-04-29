package in.chandan.service;

import in.chandan.entity.MenuTitle;
import org.springframework.stereotype.Service;

@Service
public interface MenuTitleService {
    public void addMenuTitle(MenuTitle menuTitle);
    public void updateMenuTitle(String id);
    public void deleteMenuTitle(String id);
}
