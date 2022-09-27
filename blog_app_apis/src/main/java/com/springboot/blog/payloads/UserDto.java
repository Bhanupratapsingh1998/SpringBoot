package com.springboot.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
	private int id;

	@NotNull @NotBlank
	@Size(min = 4,message = "Username name must be minimum 4 characters")
	private String name;

	@Email(message = "Your email address is not valid!")
	private String email;

	@NotNull @NotBlank
	@Size(min = 3,max = 10,message = "Password must be minimum 3 and maximum 10 characters")
	private String password;

	@NotNull @NotBlank
	private String about;
}
