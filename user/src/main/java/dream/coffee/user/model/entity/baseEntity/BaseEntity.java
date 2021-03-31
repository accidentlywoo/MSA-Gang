package dream.coffee.user.model.entity.baseEntity;

import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Embeddable
public class BaseEntity {
	private Long createdAdminId = 1L;
	@Convert(converter = LocalDateTime.class)
	private LocalDateTime createdTime = LocalDateTime.now();
	private Long updatedAdminId = 1L;
	@Convert(converter = LocalDateTime.class)
	private LocalDateTime updatedTime = LocalDateTime.now();
}