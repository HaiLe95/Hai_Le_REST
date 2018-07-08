package com.rest.api.response;


/**
 * Общий вариант ответа Api
 *
 * @param <T> payLoad в зависимости от результатавыполнения запроса может возвращать какой-то
 *           результат, или может быть NULL
 */

public class GeneralResponse<T> {

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
