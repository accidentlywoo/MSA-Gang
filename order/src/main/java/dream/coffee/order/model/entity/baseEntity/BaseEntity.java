package dream.coffee.order.model.entity.baseEntity;

import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDateTime;

@Data
@Embeddable
public class BaseEntity {
	private Long createdAdminId;
	@Convert(converter = LocalDateTime.class)
	private LocalDateTime createdTime;
	private Long updatedAdminId;
	@Convert(converter = LocalDateTime.class)
	private LocalDateTime updatedTime;
}
