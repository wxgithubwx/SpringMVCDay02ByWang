package wx.exception2;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void exception(Integer id){
        switch(id){
            case 1:{
                throw new BusinessException("Dao 系统业务异常","d1");
            }
            case 2:{
                throw new ParameterException("Dao 参数错误异常","d2");
            }
            default:
                throw new NullPointerException();
        }
    }

    public void getUser(){
        System.out.println("Dao getUser()");
    }
}
