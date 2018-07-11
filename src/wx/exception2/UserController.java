package wx.exception2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/exception")
    public void exception(Integer id){
        switch(id){
            case 1:{
                throw new BusinessException("Controller 系统业务异常","c1");
            }
            case 2:{
                throw new ParameterException("Controller 参数错误异常","c2");
            }
            case 3:{
                userService.exception(1);
            }
            case 4:{
                userService.exception(2);
            }
            case 5:{
                userService.getUserByDao(1);
            }
            case 6:{
                userService.getUserByDao(2);
            }

            default:
                throw new NullPointerException();
        }
    }




}
