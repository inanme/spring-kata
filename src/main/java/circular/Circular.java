package circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
class Host {
    private Symbiote symbiote;

    @Autowired
    public void setSymbiote(Symbiote symbiote) {
        this.symbiote = symbiote;
    }

    public Symbiote getSymbiote() {
        return symbiote;
    }
}

@Component
@Lazy
class Symbiote {
    private Host host;

    @Autowired
    public void setHost(Host host) {
        this.host = host;
    }

    public Host getHost() {
        return host;
    }
}