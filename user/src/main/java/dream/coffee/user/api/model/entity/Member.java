package dream.coffee.user.api.model.entity;

import dream.coffee.user.api.model.entity.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
public class Member extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 20, unique = true)
	private String memberId;
	@Column(nullable = false, length = 20)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	private boolean useMarketing;
	private boolean certification;
	private boolean active;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Order> orders;

	protected Member(){}

	private Member(String memberId,String memberName, String password, String email, boolean useMarketing, boolean isCertification) {
		this.memberId = memberId;
		this.name = memberName;
		this.password = password;
		this.email = email;
		this.useMarketing = useMarketing;
		this.certification = isCertification;
		this.active = true;
	}

	public static Member createMember(String memberId,String memberName, String password, String email, boolean useMarketing, boolean isCertification){
		return new Member(memberId,memberName, password, email, useMarketing,isCertification);
	}

	public Member activeMember(){
		this.active = true;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}

	public Member inActiveMember(){
		this.active = false;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}

	public Member certificate(){
		this.certification = true;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}

	public Member changeName(String name){
		this.name = name;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}

	public Member changeEmail(String email){
		this.email = email;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}

	public Member useMarketing(){
		useMarketing = true;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}

	public Member notUseMarketing(){
		useMarketing = false;

		super.setUpdatedTime(LocalDateTime.now());

		return this;
	}
}
