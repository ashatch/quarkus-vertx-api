package net.andrewhatch.quarkusvertx.bookmark.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import com.datastax.oss.quarkus.runtime.api.reactive.mapper.MutinyMappedReactiveResultSet;
import io.smallrye.mutiny.Uni;
import net.andrewhatch.quarkusvertx.bookmark.model.Bookmark;

@Dao
public interface BookmarkDaoReactive {

  @Update
  Uni<Void> update(Bookmark bookmark);

  @Select
  MutinyMappedReactiveResultSet<Bookmark> findById(String id);
}
