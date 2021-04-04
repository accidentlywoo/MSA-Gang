package dream.coffee.user.Member.service;

import dream.coffee.user.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
}
