package dream.coffee.order.api.model.entity;

import dream.coffee.order.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Read Only
 */
@Entity
@Getter
public class Member extends BaseEntity{
	@Id
	private Long id;
	private String memberId;
	private String name;
	private String password;
	private String email;
	private boolean useMarketing;
	private boolean isCertification;
	private boolean isDormant;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Order> orders;

	protected Member(){}
}
