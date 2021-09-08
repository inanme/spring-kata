package prototype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringJUnitConfig(PrototypeAppConfig.class)
public class Part4Test {

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    void shouldFailToCreateBean() {
        var service1 = context.getBean("service1", PrototypeAppConfig.Service.class);
        var service2 = context.getBean("service2", PrototypeAppConfig.Service.class);

        assertNotSame(service1.getAtomicInteger(), service2.getAtomicInteger());
    }
}
