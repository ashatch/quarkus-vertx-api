package net.andrewhatch.quarkusvertx.bookmark.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import net.andrewhatch.quarkusvertx.bookmark.dao.BookmarkDaoReactive;
import net.andrewhatch.quarkusvertx.bookmark.model.Bookmark;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookmarkReactiveService {

  @Inject
  BookmarkDaoReactive bookmarkDao;

  public Uni<Void> add(Bookmark bookmark) {
    return bookmarkDao.update(bookmark);
  }

  public Multi<Bookmark> get(String id) {
    return bookmarkDao.findById(id);
  }
}
