package dream.coffee.user.api.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class MemberInfoChangeReqDto {
	@NotNull
	private String id;
	private String name;
	private String email;
	private Boolean isUseMarketing;
}
