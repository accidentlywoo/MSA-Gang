package dream.coffee.user.api.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class MemberInfoChangeReqDto {
	private String name;
	@NotNull
	private String email;
	@NotNull
	private boolean isUseMarketing;
}
