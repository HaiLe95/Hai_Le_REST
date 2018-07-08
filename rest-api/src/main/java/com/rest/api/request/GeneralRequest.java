package com.rest.api.request;

public class GeneralRequest<T> {

    private T parameters;

    public T getParameters() {
        return parameters;
    }

    public void setParameters(T parameters) {
        this.parameters = parameters;
    }
}
