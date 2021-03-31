package dream.coffee.user.service;

import dream.coffee.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
}
