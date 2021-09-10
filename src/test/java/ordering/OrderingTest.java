package ordering;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringJUnitConfig(OrderingTest.class)
public class OrderingTest {

    @Test
    void shouldCreateBean(@Autowired AppHealthcheck appHealthcheck) {
        assertEquals("keyserver,kafka,cassandra", appHealthcheck.getNames());
    }
}

