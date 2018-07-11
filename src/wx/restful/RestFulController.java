package wx.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestFulController {

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User restful(@PathVariable("id") String id){
        System.out.println(id);
       /* return id+"";*/
        User user=new User();
        if(id.equals("1234")){
            user.setName("zhangsan");
        }
        return user;//查询指定编号的名称
    }
}
