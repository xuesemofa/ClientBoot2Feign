package org.client.com.util.resultJson;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<Object> {
    private boolean success;
    private String message;
    private Object data;
    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseResult() {
        super();
    }

    public ResponseResult(boolean success, String message, Object data, int code) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public ResponseResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}