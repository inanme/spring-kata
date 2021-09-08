package database;

import bookmark.Bookmark;

public interface BookmarkingDatabase {
    default void saveBookmark(Bookmark bookmark) {
        throw new UnsupportedOperationException();
    }
}
