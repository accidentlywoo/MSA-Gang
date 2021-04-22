package dream.coffee.user.api.Member.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class SignUpReqDto {
	@NotNull
	private String id;
	@NotNull
	private String pwd;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private boolean isUseMarketing;
	@NotNull
	private boolean isCertifivation;
}
