package dream.coffee.user.api.Member.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class SignInReqDto {
	@NotNull
	@Size(min = 5, max = 20, message = "id must be equal or grater than 5 characters and less than 16 characters")
	private String id;

	@NotNull
	@Size(min = 8, max = 20, message = "password must be equal or grater than 8 characters and less than 16 characters")
	private String pwd;
}
