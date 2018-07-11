package wx.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 访问路径：todo http://localhost:8080/admin/addUser
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody//作用是返回数据给浏览器显示
    public String addUser(){
        return "addUser";
    }


    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    @ResponseBody
    public String getUser(){
        return "getUser";
    }
}
