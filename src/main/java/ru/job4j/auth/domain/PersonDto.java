package ru.job4j.auth.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonDto {
    @NotBlank(message = "Password must be not empty")
    private String password;
}

