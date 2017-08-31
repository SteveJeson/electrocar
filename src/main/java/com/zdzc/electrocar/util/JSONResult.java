package com.zdzc.electrocar.util;

/**
 * Created by liuw on 2017/8/30.
 * JSONResult : Response JSONResult for RESTful,封装返回JSON格式的数据
 */
public class JSONResult<T> extends Result {

    private static final long serialVersionUID = -8101932431986977359L;

    /**
     * 数据
     */
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 自定义返回的结果
     * @param data
     * @param message
     * @param success
     */
    public JSONResult(boolean success, int statusCode, String message, T data) {
        super.setSuccess(success);
        super.setStatusCode(statusCode);
        super.setMessage(message);
        this.data = data;
    }

    /**
     * 成功返回数据和消息
     * @param data
     * @param message
     */
    public JSONResult(T data, String message) {
        this.data = data;
        this.setMessage(message);
        this.setStatusCode(StatusCode.OK);
    }

    /**
     * 成功返回消息
     * @param message
     */
    public JSONResult(String message) {
        this.setMessage(message);
        this.setStatusCode(StatusCode.OK);
    }

    /**
     * 成功返回数据
     */
    public JSONResult() {
        this.setStatusCode(StatusCode.OK);
    }

    /**
     * 成功返回数据
     * @param data
     */
    public JSONResult(T data) {
        this.data = data;
        this.setStatusCode(StatusCode.OK);
    }
}
