package wx.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    //返回json格式的对象
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(){
        User user=new User();
        user.setName("zhangsan");
        user.setPassword("2222");
        return user;
    }

    //接受json格式的对象
    @RequestMapping("/testJson2")
    @ResponseBody
    public User testJson2(@RequestBody User user){
        System.out.println(user.toString());
        return  user;
    }
}
