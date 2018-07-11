package wx.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理全局异常
 */

@ControllerAdvice
public class AppException {

    @ExceptionHandler(UserException.class)
    public ModelAndView handlerUserException(Exception e){
        ModelAndView view=new ModelAndView();
        view.setViewName("error.jsp");
        view.addObject("msg",e.getMessage());
        return view;
    }
}
