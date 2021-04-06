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
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String memberId;
	private String memberName;
	private String password;
	private String email;
	private boolean useMarketing;
	private boolean isCertification;
	private boolean isDormant;
	@Embedded
	private BaseEntity baseEntity;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Order> orders;

	protected Member(){}
}
