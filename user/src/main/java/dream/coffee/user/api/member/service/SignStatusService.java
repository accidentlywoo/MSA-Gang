package dream.coffee.user.api.member.service;

import dream.coffee.user.api.member.dto.InfoDto;
import dream.coffee.user.api.member.dto.SignInReqDto;
import dream.coffee.user.api.member.dto.SignUpReqDto;
import dream.coffee.user.api.model.entity.Member;
import dream.coffee.user.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SignStatusService {
	private final MemberRepository memberRepository;

	/**
	 * 회원 가입
	 *
	 * @param signUpReqDto
	 * @return
	 */
	@Transactional
	public Long signUp(SignUpReqDto signUpReqDto){
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
				signUpReqDto.getIsUseMarketing(),
				signUpReqDto.getIsCertifivation()
		);
		memberRepository.save(newMember);
		return newMember.getId();
	}

	public InfoDto signIn(SignInReqDto reqDto) {
		return null;
	}

	public void signOut(String id) {

	}
}
