package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        service.order("userA", 10000);
        service2.order("userB", 20000);

        System.out.println("userA price : " + service.getPrice());
        System.out.println("userB price : " + service2.getPrice());

        assertThat(service.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}