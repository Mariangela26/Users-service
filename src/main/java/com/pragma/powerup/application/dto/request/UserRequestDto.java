package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "The name is required")
    @Size(min = 2, message = "The name must have a minimum of two characters")
    private String name;
    @NotBlank(message = "The lastname is required")
    @Size(min = 2, message = "The lastname must have a minimum of two characters")
    private String lastname;
    @NotBlank(message = "The identification is required")
    @Pattern(regexp = "\\d+", message = "The identification must be numerical")
    @Size(min = 5, message = "The identification must have a minimum of five numbers")
    private String identification;
    @NotBlank(message = "The phone is required")
    @Pattern(regexp = "^\\+?\\d{1,12}$", message = "The cell phone number must contain a maximum of 13 characters and may contain the '+' symbol at the beginning.")
    private  String phone;
    @NotBlank(message = "The email is required")
    @Email(message = "The e-mail address must be valid")
    private String email;
    @NotBlank(message = "The pass is required")
    private String pass;
    private Long role;
}
