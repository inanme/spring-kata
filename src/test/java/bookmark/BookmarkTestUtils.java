package bookmark;

import java.util.Random;
import java.util.UUID;

public class BookmarkTestUtils {

    public static Bookmark aBookmark() {
        return Bookmark.builder()
                .contentId(UUID.randomUUID().toString())
                .user(UUID.randomUUID().toString())
                .streamPosition(new Random().nextInt(10000))
                .build();
    }
}
