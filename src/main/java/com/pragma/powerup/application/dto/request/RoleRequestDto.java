package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RoleRequestDto {
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The description is required")
    private  String description;
}
