package net.andrewhatch.quarkusvertx.bookmark.service;

import net.andrewhatch.quarkusvertx.bookmark.dao.BookmarkDao;
import net.andrewhatch.quarkusvertx.bookmark.model.Bookmark;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookmarkService {

  @Inject
  BookmarkDao dao;

  public void save(Bookmark bookmark) {
    dao.update(bookmark);
  }

  public Bookmark get(String account, String folder, String url) {
    return dao.findById(account, folder, url);
  }
}
