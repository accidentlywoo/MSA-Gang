package dream.coffee.user.api.member.service;

import dream.coffee.user.api.member.model.dto.MemberInfoChangeReqDto;
import dream.coffee.user.api.member.model.dto.MemberInfoDto;
import dream.coffee.user.api.member.model.dto.SignUpReqDto;
import dream.coffee.user.api.repository.MemberRepository;
import dream.coffee.user.api.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
	private final MemberRepository memberRepository;

	/**
	 * 회원 가입
	 *
	 * @param signUpReqDto
	 * @return
	 */
	@Transactional
	public Long SignUp(SignUpReqDto signUpReqDto){
		Optional<Member> byMemberId = memberRepository.findByMemberId(signUpReqDto.getId());
		// TODO :: Exception Handling
		if (byMemberId.isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
		}

		Member newMember = Member.createMember(
				signUpReqDto.getId(),
				signUpReqDto.getName(),
				signUpReqDto.getPwd(),
				signUpReqDto.getEmail(),
				signUpReqDto.isUseMarketing(),
				signUpReqDto.isCertifivation()
		);
		memberRepository.save(newMember);
		return newMember.getId();
	}

	/**
	 * 회원 아이디로 정보 조회
	 *
	 * @param memberId
	 * @return
	 */
	public MemberInfoDto aMemberInfo(String memberId){
		Optional<Member> findMemberById = memberRepository.findByMemberId(memberId);
		if (findMemberById.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않은 아이디 입니다.");
		}

		return MemberInfoDto
				.builder()
					.id(findMemberById.get().getMemberId())
					.name(findMemberById.get().getMemberName())
					.email(findMemberById.get().getEmail())
					.isUseMarketing(findMemberById.get().isUseMarketing())
					.isCertifivation(findMemberById.get().isCertification())
					.joinedDate(findMemberById.get().getBaseEntity().getCreatedTime())
				.build();
	}

	/**
	 * 회원 정보 변경
	 *
	 * @return
	 */
	public MemberInfoDto changeAMemberInfo(MemberInfoChangeReqDto reqDto){

		Optional<Member> byMemberId = memberRepository.findByMemberId(reqDto.getId());

		if (byMemberId.isEmpty()){
			throw new IllegalArgumentException("존재하지 않은 아이디 입니다.");
		}

		Member updatedMemberInfo = byMemberId.get().changeMemberInfo(reqDto.getName(), reqDto.getEmail(), reqDto.getIsUseMarketing());

		memberRepository.save(updatedMemberInfo);

		return MemberInfoDto
				.builder()
					.id(updatedMemberInfo.getMemberId())
					.name(updatedMemberInfo.getMemberName())
					.email(updatedMemberInfo.getEmail())
					.isCertifivation(updatedMemberInfo.isCertification())
					.isUseMarketing(updatedMemberInfo.isUseMarketing())
				.build();
	}
}
