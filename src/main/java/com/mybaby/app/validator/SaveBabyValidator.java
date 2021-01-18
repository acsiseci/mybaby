package com.mybaby.app.validator;

import com.mybaby.app.model.request.BabyRequest;
import org.springframework.stereotype.Component;

@Component
public class SaveBabyValidator {

    public void validate(BabyRequest request) {
        if (request.getName() == null) {
            throw new RuntimeException("An error occurred while save baby request");
        }
    }
}
