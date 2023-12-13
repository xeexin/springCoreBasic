package spring.springCoreBasic.sington;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefullServiceTest {
    @Test
    void StatefullServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefullService stateService1 = ac.getBean(StatefullService.class);
        StatefullService stateService2 = ac.getBean(StatefullService.class);

        // ThreadA : user A 1000
        int  userAPrice = stateService1.order("userA", 10000);
        //ThreadB : user B 2000
        int userBPrice = stateService2.order("userB", 20000);


        //Thread A 가격 조회
//        int price = stateService1.getPrice();
//        System.out.println("price = " + price);

    }

    static class TestConfig {
        @Bean
        public StatefullService statefullService() {
            return new StatefullService();
        }
    }
}