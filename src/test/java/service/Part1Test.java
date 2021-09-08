package service;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static bookmark.BookmarkTestUtils.aBookmark;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Part1Test {

    @Test
    void shouldCreateBookmarkingServiceWithoutDI() {
        assertDoesNotThrow(() -> {
            var service = new BookmarkingServiceWithoutDI();
            service.saveBookmark(aBookmark());
        });
    }

    @Test
    void shouldCreateBookmarkingServiceWithConstructorInjection() {
        assertDoesNotThrow(() -> {
            var context = new AnnotationConfigApplicationContext("service", "database");
            var store = context.getBean(BookmarkingServiceWithConstructorInjection.class);
            store.saveBookmark(aBookmark());
        });
    }

    @Test
    void shouldCreateBookmarkingServiceWithFieldInjection() {
        assertDoesNotThrow(() -> {
            var context = new AnnotationConfigApplicationContext("service", "database");
            var store = context.getBean(BookmarkingServiceWithFieldInjection.class);
            store.saveBookmark(aBookmark());
        });
    }

    @Test
    void shouldCreateBookmarkingServiceWithSetterInjection() {
        assertDoesNotThrow(() -> {
            var context = new AnnotationConfigApplicationContext("service", "database");
            var store = context.getBean(BookmarkingServiceWithSetterInjection.class);
            store.saveBookmark(aBookmark());
        });
    }
}

