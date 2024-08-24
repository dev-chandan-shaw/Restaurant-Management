package in.chandan.service.Impl;

import in.chandan.entity.MenuTitle;
import in.chandan.repository.MenuTitleRepository;
import in.chandan.service.MenuTitleService;

public class MenuTitleServiceImpl implements MenuTitleService {
    private MenuTitleRepository repository;
    @Override
    public void addMenuTitle(MenuTitle menuTitle) {
        repository.save(menuTitle);
    }

    @Override
    public void updateMenuTitle(String id) {

    }

    @Override
    public void deleteMenuTitle(String id) {

    }
}
