package wx.exception2;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    public void exception(Integer id){
        switch(id){
            case 1:{
                throw new BusinessException("service 系统业务异常","s1");
            }
            case 2:{
                throw new ParameterException("service 参数错误异常","s2");
            }
            default:
                throw new NullPointerException();
        }
    }

    public void getUserByDao(Integer id){
        userDao.exception(id);
    }

    public void getUser(){
        System.out.println("Service getUser()");
    }
}
