package com.bhakti.courseapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty(message = "Entered name is Invalid!!!")
	private String name;
	
	@Email(message = "Entered email id is Invalid!!!")
	private String email;
	
	@Min(value = 8, message = "Password must contain 8 charactes, with atleast one digit, one lowercase as well as one uppercase and special character.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* )")
	private String password;
	

}
