/**
 * @description Todo
 * @author li
 * @date 2020-09-22 00:33
 */
package studentTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import studentTracking.model.User;
import studentTracking.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 控制页面跳转控制器
 */
@Controller
public class HtmlController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/go")
    public String goAdminIndex () {
       return "forward:/WEB-INF/view/login.html";
    }

    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @return 查询结果
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String userName, String password) {
       User user = userService.getUser(userName,password);
       String result = "";
       if (user == null) {
           result = "用户不存在或用户名密码错误";
       } else {
           if (user.getFlag() == 0) {
               result = " ";
           } else if (user.getFlag() == 1) {
               result = " ";
           } else if (user.getFlag() == 2) {
               result = "student/stuMain";
           }
       }
       return result;
    }

}
