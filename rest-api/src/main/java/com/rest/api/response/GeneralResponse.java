package com.rest.api.response;

public class GeneralResponse<T>  {

    private String code;

    private T payLoad;

    public GeneralResponse() {}
    public GeneralResponse(String code, T payLoad) {
        this.code = code;
        this.payLoad = payLoad;
    }

    public String getCode() { return code; }

    public T getPayLoad() { return payLoad; }

    @Override
    public String toString() {
        return "GenerelResponse{" +
                "code='" + code + '\'' +
                ", payLoad=" + payLoad +
                '}';
    }
}
