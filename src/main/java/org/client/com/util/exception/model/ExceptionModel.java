package org.client.com.util.exception.model;

import java.io.Serializable;

/**
 * @author ld
 * @name 统一异常处理
 * @table
 * @remarks
 */
public class ExceptionModel implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionModel() {
        super();
    }

    public ExceptionModel(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionModel{" +
                "message='" + message + '\'' +
                '}';
    }
}
