package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext appConfig = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService = appConfig.getBean("memberService", MemberService.class);

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService).isSameAs(memberService2);
    }
}
