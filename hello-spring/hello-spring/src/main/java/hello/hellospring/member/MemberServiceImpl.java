package hello.hellospring.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //MemberServiceImpl은 MemberRepository도 의존하고 MemoryMemberRepository도 의존하므로 dip 위반이다.
    // 즉 추상화와 구체화에 동시에 의존하므로 좋지 않다. 변경이 있을때 문제가 된다.
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
