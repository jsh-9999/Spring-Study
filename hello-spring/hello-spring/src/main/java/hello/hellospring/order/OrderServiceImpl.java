package hello.hellospring.order;

import hello.hellospring.discount.DiscountPolicy;
import hello.hellospring.member.Member;
import hello.hellospring.member.MemberRepository;
import hello.hellospring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  // 인터페이스에만 의존하므로 DIP 원칙을 지킬 수 있다
    // 그리고 둘다 final인데 alt+enter로 생성자를 통해서 할당이 되어야한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 주문생성 요청이 오면 먼저 조회를 하고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책에 넘기는 것


        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 생성된 주문을 반환
    }
}
