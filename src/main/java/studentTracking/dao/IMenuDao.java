package studentTracking.dao;

import studentTracking.model.Menu;

import java.util.List;

/**
 * 菜单dao层接口
 */
public interface IMenuDao {

    /**
     * 获取所有的管理员一级菜单
     * @return
     */
    List<Menu> listMainMenu();

}
