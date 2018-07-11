package wx.exception2;

/**
 * 系统业务异常
 */
public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String message,String code){
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
