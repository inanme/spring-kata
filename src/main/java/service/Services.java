package service;

import bookmark.Bookmark;
import database.BookmarkingDatabase;
import database.InMemoryBookmarkingDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicInteger;

interface BookmarkingService {
    default void saveBookmark(Bookmark bookmark) {
        throw new UnsupportedOperationException();
    }
}

//NO DI
class BookmarkingServiceWithoutDI implements BookmarkingService {
    private final InMemoryBookmarkingDatabase database = new InMemoryBookmarkingDatabase();

    public void saveBookmark(Bookmark bookmark) {
        database.saveBookmark(bookmark);
    }
}

@Configuration
class AppConfig {
    @Bean
    public AtomicInteger connectionOpened() {
        return new AtomicInteger();
    }

    @Bean
    public AtomicInteger connectionClosed() {
        return new AtomicInteger();
    }
}

//Constructor-Based Dependency Injection
@Service
class BookmarkingServiceWithConstructorInjection implements BookmarkingService {

    private final BookmarkingDatabase bookmarkingDatabase;
    private final AtomicInteger connectionOpened;
    private final AtomicInteger connectionClosed;

    public BookmarkingServiceWithConstructorInjection(
            @Qualifier("logging") BookmarkingDatabase bookmarkingDatabase,
            AtomicInteger connectionOpened,
            AtomicInteger connectionClosed) {
        this.bookmarkingDatabase = bookmarkingDatabase;
        this.connectionOpened = connectionOpened;
        this.connectionClosed = connectionClosed;
    }

    @PostConstruct
    public void init() {
        connectionOpened.incrementAndGet();
    }

    @PreDestroy
    public void destroy() {
        connectionClosed.incrementAndGet();
    }

    @Override
    public void saveBookmark(Bookmark bookmark) {
        bookmarkingDatabase.saveBookmark(bookmark);
    }
}

//Field-Based Dependency Injection
@Service
class BookmarkingServiceWithFieldInjection implements BookmarkingService {

    @Autowired
    private BookmarkingDatabase bookmarkingDatabase;

    @Override
    public void saveBookmark(Bookmark bookmark) {
        bookmarkingDatabase.saveBookmark(bookmark);
    }
}

//Setter-Based Dependency Injection
@Service
class BookmarkingServiceWithSetterInjection implements BookmarkingService {

    private BookmarkingDatabase bookmarkingDatabase;

    @Override
    public void saveBookmark(Bookmark bookmark) {
        bookmarkingDatabase.saveBookmark(bookmark);
    }

    @Autowired
    public void setBookmarkingDatabase(BookmarkingDatabase bookmarkingDatabase) {
        this.bookmarkingDatabase = bookmarkingDatabase;
    }
}