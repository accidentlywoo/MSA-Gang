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

	/**
	 * 멤버계정 생성 - 회원가입리
	 *
	 * @param memberId
	 * @param password
	 * @param email
	 * @param useMarketing
	 * @return
	 */
	public static Member createMember(String memberId,String memberName, String password, String email, boolean useMarketing, boolean isCertification){
		return new Member(memberId,memberName, password, email, useMarketing,isCertification);
	}

	public Member activeMember(){
		this.active = false;
		return this;
	}

	public Member inActiveMember(){
		this.active = false;
		return this;
	}

	public Member certificateMember(){
		this.certification = true;
		return this;
	}

	public Member inCertificateMember(){
		this.certification = false;
		return this;
	}

	/**
	 *  멤버 회원 정보 변경
	 * 	  :: 회원이 자유롭게 변경할 수 있는 정보 : 이름, 이메일, 마케팅 수신 여부.
	 *
	 * @param name
	 * @param email
	 * @param isUseMarketing
	 * @return
	 */
	public Member changeMemberInfo(String name, String email, Boolean isUseMarketing){
		if(name != null){
			name = name;
		}
		if(email != null) {
			this.email = email;
		}
		if(isUseMarketing != null) {
			useMarketing = isUseMarketing;
		}
		super.setUpdatedTime(LocalDateTime.now());
		return this;
	}

}
