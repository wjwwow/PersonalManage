package com.davis.DTO;

/**
 * @author Davis
 * @date 2021-11-17 - 18:22
 * @description
 */
public class ResultDTO<T> {
    private Boolean result;
    private String message;
    private T data;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
