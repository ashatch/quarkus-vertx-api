package net.andrewhatch.quarkusvertx.bookmark.dao;

import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;
import net.andrewhatch.quarkusvertx.bookmark.mapper.BookmarkMapper;
import net.andrewhatch.quarkusvertx.bookmark.mapper.BookmarkMapperBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class BookmarkDaoProducer {
  private final BookmarkDao bookmarkDao;
  private final BookmarkDaoReactive bookmarkDaoReactive;

  @Inject
  public BookmarkDaoProducer(QuarkusCqlSession session) {
    BookmarkMapper mapper = new BookmarkMapperBuilder(session).build();
    bookmarkDao = mapper.bookmarkDao();
    bookmarkDaoReactive = mapper.bookmarkDaoReactive();
  }

  @Produces
  @ApplicationScoped
  BookmarkDao produceBookmarkDao() {
    return bookmarkDao;
  }

  @Produces
  @ApplicationScoped
  BookmarkDaoReactive produceBookmarkDaoReactive() {
    return bookmarkDaoReactive;
  }
}
