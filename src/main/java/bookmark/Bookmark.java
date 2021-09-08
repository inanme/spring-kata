package bookmark;

import lombok.Builder;
import lombok.Value;

import java.time.Clock;
import java.time.OffsetDateTime;

@Builder
@Value
public class Bookmark {
    String user;
    String contentId;
    Integer streamPosition;
    @Builder.Default
    OffsetDateTime timestamp = OffsetDateTime.now(Clock.systemUTC());
}
