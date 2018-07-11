package wx.interceptor.login;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 如果没有登陆，则跳转到登陆页
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        System.out.println("pre");
        //如果访问的是登陆界面返回true
        String requestURI = request.getRequestURI();
        if(requestURI.contains("login")||requestURI.contains("toLogin")){
            return true;
        }

        User user = (User)request.getSession().getAttribute("USER_SESSION");
        if(user!=null){
            return true;
        }
            request.getSession().setAttribute("msg","请先登陆");
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
