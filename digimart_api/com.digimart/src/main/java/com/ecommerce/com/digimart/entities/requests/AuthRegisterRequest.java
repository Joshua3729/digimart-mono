package com.ecommerce.com.digimart.entities.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegisterRequest extends AuthRequest {
    @NotBlank(message = "Profile first name is required")
    @Size(max = 45)
    public String firstName;

    @NotBlank(message = "Profile last name is required")
    @Size(max = 45)
    public String lastName;
}
