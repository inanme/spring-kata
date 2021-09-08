package database;

import bookmark.Bookmark;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class InMemoryBookmarkingDatabase implements BookmarkingDatabase {

    private Map<String, List<Bookmark>> database = new HashMap<>();

    @Override
    public void saveBookmark(Bookmark bookmark) {
        database.compute(bookmark.getUser(), (user, bookmarks) -> {
            if (bookmarks == null) {
                var newList = new LinkedList<Bookmark>();
                newList.add(bookmark);
                return newList;
            } else {
                bookmarks.add(bookmark);
                return bookmarks;
            }
        });
    }
}

@Repository
@Qualifier("logging")
class InMemoryLoggingBookmarkingDatabase implements BookmarkingDatabase {

    private BookmarkingDatabase bookmarkingDatabase;

    public InMemoryLoggingBookmarkingDatabase(BookmarkingDatabase bookmarkingDatabase) {
        this.bookmarkingDatabase = bookmarkingDatabase;
    }

    @Override
    public void saveBookmark(Bookmark bookmark) {
        bookmarkingDatabase.saveBookmark(bookmark);
        System.out.println(bookmark);
    }
}
