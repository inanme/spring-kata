package ordering;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

interface Downstream {
    String getName();
}

@Component
@Order(2)
class Kafka implements Downstream {
    @Override
    public String getName() {
        return "kafka";
    }
}

@Component
@Order(3)
class Cassandra implements Downstream {
    @Override
    public String getName() {
        return "cassandra";
    }
}


@Component
@Order(1)
class Keyserver implements Downstream {
    @Override
    public String getName() {
        return "keyserver";
    }
}

@Component
class AppHealthcheck {
    private final List<Downstream> dependencies;

    public AppHealthcheck(List<Downstream> dependencies) {
        this.dependencies = dependencies;
    }

    public String getNames() {
        return dependencies.stream().map(Downstream::getName).collect(Collectors.joining(","));
    }
}