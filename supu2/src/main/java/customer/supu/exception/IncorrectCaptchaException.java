package customer.supu.exception;

import org.apache.shiro.authc.AuthenticationException;

public class IncorrectCaptchaException extends AuthenticationException {

    /**
     *
     */
    private static final long serialVersionUID = -8191806849662676124L;

    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String msg) {
        super(msg);
    }

    public IncorrectCaptchaException(Throwable t) {
        this(t.toString(), t);
    }

    public IncorrectCaptchaException(String msg, Throwable t) {
        super(msg, t);
        this.setStackTrace(t.getStackTrace());
    }
}
