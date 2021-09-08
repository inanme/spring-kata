package circular;

import org.springframework.stereotype.Component;

@Component
class Host {
    private final Symbiote symbiote;

    public Host(Symbiote symbiote) {
        this.symbiote = symbiote;
    }
}

@Component
class Symbiote {
    private final Host host;


    public Symbiote(Host host) {
        this.host = host;
    }
}