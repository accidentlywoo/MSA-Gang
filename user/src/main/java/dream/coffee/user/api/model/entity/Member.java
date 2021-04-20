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

	private Member(String memberId,String memberName, String password, String email, boolean useMarketing, boolean isCertification) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.password = password;
		this.email = email;
		this.useMarketing = useMarketing;
		this.isCertification = isCertification;
		this.isDormant = false;
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

	/**
	 * 멤버 휴면 처리
	 *
	 * @param isDormant
	 * @return
	 */
	public Long changeDormantMember(boolean isDormant){
		this.isDormant = isDormant;
		return this.id;
	}

	/**
	 * 멤버 인증 처리
	 *
	 * @param isCertification
	 * @return
	 */
	public Long changeMemberCertificate(boolean isCertification){
		this.isCertification = isCertification;
		return this.id;
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
			memberName = name;
		}
		if(email != null) {
			this.email = email;
		}
		if(isUseMarketing != null) {
			useMarketing = isUseMarketing;
		}
		this.baseEntity.setUpdatedTime(LocalDateTime.now());
		return this;
	}

}
