package service;

import bookmark.Bookmark;
import database.InMemoryBookmarkingDatabase;

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

//Constructor-Based Dependency Injection
class BookmarkingServiceWithConstructorInjection implements BookmarkingService {

}

//Field-Based Dependency Injection
class BookmarkingServiceWithFieldInjection implements BookmarkingService {

}

//Setter-Based Dependency Injection
class BookmarkingServiceWithSetterInjection implements BookmarkingService {

}