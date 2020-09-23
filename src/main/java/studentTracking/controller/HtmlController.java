/**
 * @description Todo
 * @author li
 * @date 2020-09-22 00:33
 */
package studentTracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制页面跳转控制器
 */
@Controller
public class HtmlController {

    /**
     * 跳转管理员首页
     * @return
     */
    @RequestMapping("/go")
    public String goAdminIndex () {
       return "forward:/WEB-INF/view/admin/index.html";
    }

    /**
     * 跳转教师信息页
     * @return
     */
    @RequestMapping("/goteacher")
    public String goTeacher () {
        return "forward:/WEB-INF/view/admin/teacherlist.html";
    }

}
