package com.vitthal.BloggingApp_API.payload;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.vitthal.BloggingApp_API.moduls.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer userId;
	
//	@NotNull			// @NotNull is check only not not null but not check blank due to this we use @NotBlank
	@NotBlank			// @NotBlank is check not not null and blank also
	@Size(min=4, message= "User name must be minimum 4 charactor")
	private String name;
	
	@Email(message= "email adrees is not valid")
	private String email;
	
	@NotBlank
	@Size(min=8, max=16, message= "Passowrd must me min of 5 charactor and max 16 charactor")
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$")
	private String password;
	
//	we can use pattern for password for that need to add expression in :  @pattern(regexp="......")
	
//	^                 # start-of-string
//	(?=.*[0-9])       # a digit must occur at least once
//	(?=.*[a-z])       # a lower case letter must occur at least once
//	(?=.*[A-Z])       # an upper case letter must occur at least once
//	(?=.*[@#$%^&+=])  # a special character must occur at least once
//	(?=\S+$)          # no whitespace allowed in the entire string
//	.{8,16}           # anything, at least eight places & maximum sixteen places though
//	$                 # end-of-string
	
//	if we use pattern in pattern if size is mansion then no need to use @size(min=..., max=...)
	

	@NotBlank
	private String about;
	
	
	private Set<CommentDto> comment=new HashSet<>();

}
