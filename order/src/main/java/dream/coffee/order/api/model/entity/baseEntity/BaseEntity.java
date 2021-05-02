package dream.coffee.order.api.model.entity.baseEntity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
	private Long createdAdminId;
	private LocalDateTime createdTime;
	private Long updatedAdminId;
	private LocalDateTime updatedTime;
}
