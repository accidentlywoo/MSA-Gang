package dream.coffee.user.api.Member.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class SignInReqDto {
	@NotNull
	private String id;
	@NotNull
	private String pwd;
}
