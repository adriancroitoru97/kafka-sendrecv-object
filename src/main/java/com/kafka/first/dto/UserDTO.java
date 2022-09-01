package com.kafka.first.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "email",
        "CNP"
})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Range(min = 1, max = 10000, message = "Invalid ID")
    private Integer id;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Length(max = 30, message = "First name is too long")
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    @Length(max = 30, message = "Last name is too long")
    private String lastName;

    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email address")
    @Length(max = 50, message = "Email address is too long")
    private String email;

    @NotNull(message = "CNP is mandatory")
    @NotBlank(message = "CNP is mandatory")
    @Length(max = 13, min = 13, message = "Wrong CNP format")
    private String CNP;
}
