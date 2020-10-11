package net.andrewhatch.quarkusvertx.bookmark.dao;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import net.andrewhatch.quarkusvertx.bookmark.model.Bookmark;

@Dao
public interface BookmarkDao {
  @Update
  void update(Bookmark fruit);

  @Select
  Bookmark findById(
      String accountId,
      String folderId,
      String url);

  @Select
  PagingIterable<Bookmark> findInFolder(
      String accountId,
      String folderId);
}
