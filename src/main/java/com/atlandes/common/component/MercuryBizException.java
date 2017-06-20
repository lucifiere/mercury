package com.atlandes.common.component;

/**
 * Created by XD.Wang on 2017/6/20.
 * Mercury业务异常
 */
public class MercuryBizException extends RuntimeException {

    private static final long serialVersionUID = -7464087034363911027L;
    private String code;
    private Object[] args;
    private String textMessage;

    public MercuryBizException(String msg) {
        super(msg);
    }

    public MercuryBizException(String code, String msg) {
        super(code + ": " + msg);
        this.code = code;
    }

    public MercuryBizException(String code, String msg, Throwable cause) {
        super(code + ": " + msg, cause);
        this.code = code;
    }

    public MercuryBizException(String code, Object[] args, String msg) {
        super(code + ": " + msg);
        this.code = code;
        this.args = args;
    }

    public MercuryBizException(String code, Object[] args, String msg, Throwable cause) {
        super(code + ": " + msg, cause);
        this.code = code;
        this.args = args;
    }

    public MercuryBizException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String string) {
        this.code = string;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public void setArgs(Object[] objects) {
        this.args = objects;
    }

    public String getTextMessage() {
        return this.textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

}
