package dream.coffee.user.api.Member.model.dto;

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
	private boolean isUseMarketing;
	@NotNull
	private boolean isCertifivation;
	@NotNull
	private LocalDateTime joinedDate;
}
