package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RestEmployeeRequestDto {

    @NotBlank(message = "The restaurant id is required")
    private String restaurantId;
    @NotBlank(message = "The employee is required")
    private String userId;
}