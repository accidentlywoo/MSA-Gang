package dream.coffee.user.api.member.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class InfoDto {
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
