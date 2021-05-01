package dream.coffee.user.api.model.entity.baseEntity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
	private Long createdAdminId = 1L;
	private LocalDateTime createdTime = LocalDateTime.now();
	private Long updatedAdminId = 1L;
	private LocalDateTime updatedTime = LocalDateTime.now();
}
