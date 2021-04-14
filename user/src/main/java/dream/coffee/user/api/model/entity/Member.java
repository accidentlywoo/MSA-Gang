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
	public Long changeCertificateMember(boolean isCertification){
		this.isCertification = isCertification;
		return this.id;
	}

	/**
	 * 멤버 마케팅 사용여부 처
	 *
	 * @param useMarketing
	 * @return
	 */
	public Long changeMarketingMember(boolean useMarketing){
		this.useMarketing = useMarketing;
		this.baseEntity.setUpdatedTime(LocalDateTime.now());
		return this.id;
	}

}
