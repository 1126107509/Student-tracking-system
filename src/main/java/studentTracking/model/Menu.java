package studentTracking.model;

import java.util.List;

/**
 * 菜单实体类
 */
public class Menu {
    /**
     * 菜单id
     */
    private long menuId;
    /**
     * 父级菜单
     */
    private long parentMenuId;
    /**
     * 菜单名单
     */
    private String menuName;

    //存取子菜单
    private List<Menu> sonMenus;


    /**
     * 菜单路径
     */
    private String address;

    /**
     * 菜单类型 0管理员 1教师 2学生
     */
    private int menuType;

    private String url;


    private String promptName;
    private String goal;
    private String image;
    private String imageShow;
    private String menuShow;
    private String expressshun;
    private String deleteFlag;

    public Menu() {
    }

    public Menu(long parentMenuId, String menuName, List<Menu> sonMenus, String address,
                int menuType) {
        this.parentMenuId = parentMenuId;
        this.menuName = menuName;
        this.sonMenus = sonMenus;
        this.address = address;
        this.menuType = menuType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromptName() {
        return promptName;
    }

    public void setPromptName(String promptName) {
        this.promptName = promptName;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageShow() {
        return imageShow;
    }

    public void setImageShow(String imageShow) {
        this.imageShow = imageShow;
    }

    public String getMenuShow() {
        return menuShow;
    }

    public void setMenuShow(String menuShow) {
        this.menuShow = menuShow;
    }

    public String getExpressshun() {
        return expressshun;
    }

    public void setExpressshun(String expressshun) {
        this.expressshun = expressshun;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<Menu> getSonMenus() {
        return sonMenus;
    }

    public void setSonMenus(List<Menu> sonMenus) {
        this.sonMenus = sonMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", parentMenuId=" + parentMenuId +
                ", menuName='" + menuName + '\'' +
                ", sonMeus=" + sonMenus +
                ", address='" + address + '\'' +
                ", imageShow='" + imageShow + '\'' +
                '}';
    }
}
