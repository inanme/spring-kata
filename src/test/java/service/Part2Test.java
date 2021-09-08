package service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static bookmark.BookmarkTestUtils.aBookmark;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ComponentScan({"database", "service"})
@SpringJUnitConfig(Part2Test.class)
public class Part2Test {

    @Autowired
    private ConfigurableApplicationContext context;

    /**
     * GOAL: Use @Qualifier and @Primary
     * 1. implement a database layer base on the in memory implementation which logs the bookmark
     * 2. wire it to service
     */
    @Test
    void shouldCreateBookmarkingServiceWithLoggingInMemoryDatabase() {
        assertDoesNotThrow(() -> {
            var store = context.getBean(BookmarkingServiceWithConstructorInjection.class);
            store.saveBookmark(aBookmark());
        });
    }
}
