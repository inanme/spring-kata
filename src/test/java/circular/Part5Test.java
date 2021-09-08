package circular;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@ComponentScan
@SpringJUnitConfig(Part5Test.class)
public class Part5Test {

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    @Disabled
    void shouldFailToCreateBean() {
        assertThrows(UnsatisfiedDependencyException.class, () -> context.getBean(Host.class));
    }

    @Test
    void shouldCreateBean() {
        assertDoesNotThrow(() -> context.getBean(Host.class));
        assertNotNull(context.getBean(Host.class));
    }


    @Test
    void symbioteDependsOnHost(@Autowired Symbiote symbiote, @Autowired Host host) {
        //final Instant instant = Instant.now();
        //assertTrue(host.instant.isBefore(symbiote.instant));
        assertTrue(false);
    }
}
