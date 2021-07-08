package hello.hellospring;

import hello.hellospring.discount.FixDiscountPolicy;
import hello.hellospring.member.*;
import hello.hellospring.order.OrderService;
import hello.hellospring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());

    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    }
}
