package wx.interceptor.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    /**
     * 登陆界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return  "WEB-INF/jsp/login.jsp";
    }

    /**
     * 登陆主页
     * @return
     */
    @RequestMapping("/toMain")
    public String toMain(){
        return "WEB-INF/jsp/main.jsp";
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logOut(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/toLogin";
    }


    /**
     * 登录
     */
    @RequestMapping("/login")
    public String  login(User user, HttpSession session,HttpServletRequest request){

            if(user.getName()!=null&&user.getName().equals("admin")
                    &&user.getPassword()!=null&&user.getPassword().equals("admin")){
                session.setAttribute("USER_SESSION",user);
                return "redirect:/toMain";
            }
            else if(user.getName()==null&&user.getPassword()==null){
                return "redirect:/toLogin";
            }
            else{
                request.getSession().setAttribute("msg","用户名或密码错误");
                return "redirect:/toLogin";
            }

    }

}
