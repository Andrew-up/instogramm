package com.example.instogramm.validators;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseErrorValidator {
    public ResponseEntity<Object> mappedValidatorService(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();
            if(CollectionUtils.isEmpty(bindingResult.getAllErrors())){
                for (ObjectError error: bindingResult.getAllErrors()){
                    errorMap.put(error.getCode(),error.getDefaultMessage());
                }
            }
            for(FieldError error:bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return  new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
