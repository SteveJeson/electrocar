package com.zdzc.electrocar.util;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by liuw on 2017/8/30.
 */
public enum StatusCode {
    /**
     * 成功
     */
    OK(1, "成功"),
    /**
     * 未授权
     */
    UNAUTHORIZED(401, "未授权"),
    TOKEN_IS_INVALID(402,"令牌失效"),
    FORBIDDEN(403, "禁止访问"),
    /**
     * 404
     */
    NOT_FOUND(404, "无法找到文件"),

    METHOD_NOT_ALLOWED(405, "不允许的请求方法"),

    NOT_ACCEPTABLE(406, "不接受的请求"),

    CONFLICT(409, "资源冲突"),

    UNSUPPORTED_MEDIA_TYPE(415, "不支持的Media Type"),

    SERVICE_UNAVAILABLE(503, "服务不可用"),

    GATEWAY_TIMEOUT(504, "请求服务超时"),
    /**
     * 服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "内部服务器错误");


    int key;
    String value;

    StatusCode(int key, String value) {
        this.key = key;
        this.value = value;
    }


    @JsonValue
    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public StatusCode get(int key) {
        StatusCode[] list = values();
        for (StatusCode statusCode : list) {
            if (key == statusCode.getKey()) {
                return statusCode;
            }
        }
        return null;
    }
}
