package wx.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public void login(){
        User user=new User();
        userService.login(user);
    }

  /*  *//**
     * 只能处理当前Controller的异常
     * @return
     *//*
    @ExceptionHandler(UserException.class)
    public String handlerUserException(){
        return "error.jsp";  //默认返回的是视图
    }
*/





}
