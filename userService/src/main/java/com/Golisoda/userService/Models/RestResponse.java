package com.Golisoda.userService.Models;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class RestResponse<T> {

    private List<String> errors;

    private T data;

    /**
     * Error is included or not
     *
     * @return true or false
     */
    public boolean isError() {
        return !CollectionUtils.isEmpty(errors);
    }

    /**
     * Add a new error message
     *
     * @param errorMsg Error Message
     */
    public void addError(String errorMsg) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(errorMsg);
    }
}
