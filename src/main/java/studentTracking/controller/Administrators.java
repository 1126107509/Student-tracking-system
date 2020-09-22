package studentTracking.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import studentTracking.model.Menu;
import studentTracking.service.IMenuService;

import java.util.List;

/**
 * 后台管理员控制器
 */
@Controller
public class Administrators {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/menu")
    @ResponseBody
    public String showMenu() {
        List<Menu> menus = menuService.listMenu();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSONArray.fromObject(menus));
        System.out.println(JSONArray.fromObject(menus));
        return jsonObject.toString();
    }
}
