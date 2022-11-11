package br.com.daniel.rest.exceptions;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> listErrors;

    public ApiErrors(List<String> erros){
        this.listErrors = erros;
    }

    public ApiErrors(String msg){
        this.listErrors = Arrays.asList(msg);
    }
}
