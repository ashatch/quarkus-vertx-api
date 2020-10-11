package net.andrewhatch.quarkusvertx.bookmark.mapper;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import net.andrewhatch.quarkusvertx.bookmark.dao.BookmarkDao;
import net.andrewhatch.quarkusvertx.bookmark.dao.BookmarkDaoReactive;

@Mapper
public interface BookmarkMapper {
  @DaoFactory
  BookmarkDao bookmarkDao();

  @DaoFactory
  BookmarkDaoReactive bookmarkDaoReactive();
}
