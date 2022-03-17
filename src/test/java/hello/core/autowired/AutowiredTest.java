package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean {

        @Autowired(required = false)
        public void setNo1Bean(Member no1Bean) {
            System.out.println("no Bean 1 = " + no1Bean);
        }

        @Autowired
        public void setNo2Bean(@Nullable Member no1Bean) {
            System.out.println("no Bean 2 = " + no1Bean);
        }

        @Autowired
        public void setNo3Bean(Optional<Member> no1Bean) {
            System.out.println("no Bean 3 = " + no1Bean);
        }
    }
}
