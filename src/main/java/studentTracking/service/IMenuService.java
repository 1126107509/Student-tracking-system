package studentTracking.service;

import studentTracking.model.Menu;

import java.util.List;

public interface IMenuService {

    /**
     * 获取所有的管理员一级菜单
     * @return
     */
    List<Menu> listMenu();

}
