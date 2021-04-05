package dream.coffee.user.Member.service;

import dream.coffee.user.Member.repository.MemberRepository;
import dream.coffee.user.model.dto.SignUpReqDto;
import dream.coffee.user.model.entity.Member;
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
		if (byMemberId.isPresent()){
			// TODO :: Exception Handling
			throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
		}
		Member newMember = Member.createMember(
				signUpReqDto.getId(), signUpReqDto.getName(),
				signUpReqDto.getPwd(), signUpReqDto.getEmail(),
				signUpReqDto.isUseMarketing(), signUpReqDto.isCertifivation()
		);
		memberRepository.save(newMember);
		return newMember.getId();
	}
}
