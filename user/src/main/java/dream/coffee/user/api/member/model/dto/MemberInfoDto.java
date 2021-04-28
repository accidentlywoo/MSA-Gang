package dream.coffee.user.api.member.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class MemberInfoDto {
	@NotNull
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private Boolean isUseMarketing;
	@NotNull
	private Boolean isCertifivation;
	@NotNull
	private LocalDateTime joinedDate;
}
