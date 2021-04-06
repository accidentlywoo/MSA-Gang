package dream.coffee.order.api.model.entity.baseEntity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class BaseEntity {
	private Long createdAdminId;
	private LocalDateTime createdTime;
	private Long updatedAdminId;
	private LocalDateTime updatedTime;
}
