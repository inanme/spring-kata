package circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Lazy
class Host {

    final Instant instant = Instant.now();

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
@DependsOn("host")
class Symbiote {

    final Instant instant = Instant.now();

    private Host host;

    @Autowired
    public void setHost(Host host) {
        this.host = host;
    }

    public Host getHost() {
        return host;
    }
}