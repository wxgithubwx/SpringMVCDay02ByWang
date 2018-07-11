package wx.exception;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {

    //一般的处理异常
    public void login(User user){
        if(user.getName()==null||user.getPassword()==null){
            //抛出一个UserException
            throw new UserException("用户名和密码不能为空");
           /* 自定义异常类上有注解
            @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "用户名和密码不能为空")
           比较有无区别
           */ //throw  new RuntimeException("用户名和密码不能为空");
        }
    }

    //能够处理一个Controller下所有异常

}
