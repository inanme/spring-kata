package prototype;

import java.util.concurrent.atomic.AtomicInteger;

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


    public AtomicInteger prototypeBean() {
        return new AtomicInteger();
    }

    public Service service1(AtomicInteger atomicInteger) {
        return new Service(atomicInteger);
    }

    public Service service2(AtomicInteger atomicInteger) {
        return new Service(atomicInteger);
    }
}
