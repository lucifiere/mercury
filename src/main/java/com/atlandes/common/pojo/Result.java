package com.atlandes.common.pojo;

import java.io.Serializable;

/**
 * Created by XD.Wang on 2017/6/14.
 * 调用结果
 */
@SuppressWarnings("unchecked")
public class Result<T> implements Serializable {

    private final static int SUCCESS = 1;
    private final static int FAILED = 0;
    private final static String DEFAULT_SUC_COMMENT = "操作成功！";
    private final static String DEFAULT_FAL_COMMENT = "操作失败！";

    private int code = 0;

    private String msg;

    private T data;

    private Result(String msg, int code, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> suc(String msg, T model) {
        return new Result(msg, SUCCESS, model);
    }

    public static <T> Result<T> suc(String msg) {
        return new Result(msg, SUCCESS, null);
    }

    public static <T> Result<T> suc(T model) {
        return new Result(DEFAULT_SUC_COMMENT, SUCCESS, model);
    }

    public static <T> Result<T> suc() {
        return new Result(DEFAULT_SUC_COMMENT, SUCCESS, null);
    }

    public static <T> Result<T> fail(String msg, T model) {
        return new Result(msg, FAILED, model);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(msg, FAILED, null);
    }

    public static <T> Result<T> fail(T model) {
        return new Result(DEFAULT_FAL_COMMENT, FAILED, model);
    }

    public static <T> Result<T> fail() {
        return new Result(DEFAULT_FAL_COMMENT, FAILED, null);
    }

}
