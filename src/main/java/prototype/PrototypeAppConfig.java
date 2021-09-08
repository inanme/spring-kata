package prototype;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class PrototypeAppConfig {

    public class Service {
        private final AtomicInteger atomicInteger;

        public Service(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        public AtomicInteger getAtomicInteger() {
            return atomicInteger;
        }
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AtomicInteger prototypeBean() {
        return new AtomicInteger();
    }

    @Bean
    public Service service1(AtomicInteger atomicInteger) {
        return new Service(atomicInteger);
    }

    @Bean
    public Service service2(AtomicInteger atomicInteger) {
        return new Service(atomicInteger);
    }
}
