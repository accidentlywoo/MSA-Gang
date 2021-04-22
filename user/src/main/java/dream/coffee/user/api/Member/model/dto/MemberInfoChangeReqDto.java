package dream.coffee.user.api.Member.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class MemberInfoChangeReqDto {
	@NotNull
	private String id;
	private String name;
	private String email;
	private Boolean isUseMarketing;
}
