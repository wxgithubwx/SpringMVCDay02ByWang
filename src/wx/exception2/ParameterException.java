package wx.exception2;

/**
 * 参数异常
 */
public class ParameterException extends RuntimeException {
    String code;//异常码
    public ParameterException(String message,String code){
        super(message);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
