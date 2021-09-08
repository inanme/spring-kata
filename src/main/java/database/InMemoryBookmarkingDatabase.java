package database;

import bookmark.Bookmark;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemoryBookmarkingDatabase {

    private Map<String, List<Bookmark>> database = new HashMap<>();

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
