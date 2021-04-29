package dream.coffee.user.api.member.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class SignUpReqDto {
	@NotNull
	@Size(min = 5, max = 20, message = "id must be equal or grater than 5 characters and less than 16 characters")
	private String id;

	@NotNull
	@Size(min = 8, max = 20, message = "password must be equal or grater than 8 characters and less than 16 characters")
	private String pwd;

	@NotNull
	@Size(max = 20, message = "name must be less than 20 characters")
	private String name;

	@NotNull
	@Size(min = 2, message = "email not be less than 2 characters")
	@Email
	private String email;

	@NotNull
	private Boolean isUseMarketing;

	@NotNull
	private Boolean isCertifivation;
}
