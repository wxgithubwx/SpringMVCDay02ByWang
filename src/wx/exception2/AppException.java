package wx.exception2;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理全局异常
 */

@ControllerAdvice
public class AppException {

    @ExceptionHandler({BusinessException.class,ParameterException.class,RuntimeException.class})
    public ModelAndView handlerUserException(HttpServletRequest request, HttpServletResponse response,Exception e) throws IOException {
        //普通请求：发送异常直接跳转到错误页面
        //ajax请求：返回错误的json数据 {"msg":"xxx业务异常",code:11} 、  xxx异常
        //判断请求的类型
        if(request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With")
                .equalsIgnoreCase("XMLHttpRequest")){
            response.setCharacterEncoding("utf-8");

            if (e instanceof BusinessException){
                BusinessException be=(BusinessException) e;
                response.getWriter().print(e.getMessage()+" "+be.getCode());
            }else{
                response.getWriter().print(e.getMessage());
            }
        }else{
            Map<String,Object> model=new HashMap<>();
            model.put("ex",e);
            if(e instanceof  BusinessException){
                return  new ModelAndView("WEB-INF/errors/error-business.jsp",model);
            }
            if(e instanceof  ParameterException){
                return  new ModelAndView("WEB-INF/errors/error-parameter.jsp",model);
            }else{
                return  new ModelAndView("WEB-INF/errors/error.jsp",model);
            }
        }

        return null;
    }
}
