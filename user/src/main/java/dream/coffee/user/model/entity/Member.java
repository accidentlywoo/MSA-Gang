package dream.coffee.user.model.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	protected Member(){}

	private Member(String memberId,String memberName, String password, String email, boolean useMarketing, boolean isCertification) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.password = password;
		this.email = email;
		this.useMarketing = useMarketing;
		this.isCertification = isCertification;
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
		return this.id;
	}

}
