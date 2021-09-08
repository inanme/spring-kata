package service;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Part3Test {

    /**
     * add it to the service file
     *
     * @Configuration
     * class AppConfig {
     *     @Bean
     *     public AtomicInteger connectionOpened() {
     *         return new AtomicInteger();
     *     }
     *
     *     @Bean
     *     public AtomicInteger connectionClosed() {
     *         return new AtomicInteger();
     *     }
     * }
     *
     */
    @Test
    void shouldIncreaseCounterPredestroy() {
        var context = new AnnotationConfigApplicationContext("service", "database");
        assertNotNull(context.getBean(BookmarkingServiceWithConstructorInjection.class));
        var connectionOpened = context.getBean("connectionOpened", AtomicInteger.class);
        var connectionClosed = context.getBean("connectionClosed", AtomicInteger.class);
        context.close();
        assertEquals(1, connectionOpened.get());
        assertEquals(1, connectionClosed.get());
    }
}
