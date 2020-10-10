package net.andrewhatch.quarkusvertx;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class ExampleResource {

  @Query
  public String hello() {
    return "hello";
  }
}
