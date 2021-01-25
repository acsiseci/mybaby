package com.mybaby.app.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SignUpAndSaveBabyRequest {
    private String name;
    private String email;
    private String password;
    private String familyCode;
    private List<BabyRequest> baby;
}
