package dream.coffee.user.api.member.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class InfoChangeReqDto {
	@NotNull
	@Size(min = 5, max = 20, message = "id must be equal or grater than 5 characters and less than 16 characters")
	private String id;

	@Size(max = 20, message = "name must be less than 20 characters")
	private String name;

	@Size(min = 2, message = "email not be less than 2 characters")
	@Email
	private String email;

	private Boolean isUseMarketing;
}
