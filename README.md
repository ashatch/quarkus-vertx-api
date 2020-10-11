# quarkus-vertx-api project

Exploration of Quarkus.

## Bootstrap

```bash
brew install gu

mvn io.quarkus:quarkus-maven-plugin:1.8.1.Final:create \
    -DprojectGroupId=net.andrewhatch.quarkus-vertx-api \
    -DprojectArtifactId=quarkus-vertx-api \
    -DclassName="net.andrewhatch.quarkusvertx.Api" \
    -Dpath="/hello"
```

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-vertx-api-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-vertx-api-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/quarkus-vertx-api-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Build and run the docker image

```bash
docker build -f src/main/docker/Dockerfile.native -t quarkus-vertx-api/api .
docker run -i --rm -p 8080:8080 quarkus-vertx-api/api:latest
```

## Build using the Multistage technique

```bash
docker build -f src/main/docker/Dockerfile.multistage -t quarkus-vertx-api/api .
docker run -i --rm -p 8080:8080 quarkus-vertx-api/api:latest
```

## Switch to vertx

```
./mvnw quarkus:add-extension -Dextensions="vertx"
```

## Running

```
./mvnw quarkus:dev
```

## GraphQL UI

* http://localhost:8080/graphql-ui/

## Cassandra

```
docker run \                                                                                                                                                                            
   --name local-cassandra-instance \
   -p 7000:7000 \
   -p 7001:7001 \
   -p 7199:7199 \
   -p 9042:9042 \
   -p 9160:9160 \
   -p 9404:9404 \
   -d \
   launcher.gcr.io/google/cassandra3

docker exec -it local-cassandra-instance cqlsh -e "CREATE KEYSPACE IF NOT EXISTS k1 WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}"
docker exec -it local-cassandra-instance cqlsh -e "CREATE TABLE IF NOT EXISTS k1.bookmark(accountId text, folderId text, url text, label text, PRIMARY KEY((accountId), folderId, url))"
```

## Reading list:

* https://quarkus.io/guides/microprofile-health
* https://www.youtube.com/watch?v=-1wijnrTxs0
* https://quarkus.io/guides/microprofile-fault-tolerance
* https://quarkus.io/guides/amazon-dynamodb
* https://github.com/phillip-kruger/graphql-example
* https://quarkus.io/blog/supersonic-subatomic-graphql/
* https://github.com/wesleyfuchter/cqrs-quarkus-kafka
* https://github.com/hasura/3factor
* https://quarkus.io/guides/getting-started-reactive
* https://smallrye.io/smallrye-mutiny/
* https://quarkus.io/guides/config#yaml
* https://quarkus.io/guides/logging
* https://quarkus.io/guides/vertx
* https://developers.redhat.com/blog/2019/11/18/how-quarkus-brings-imperative-and-reactive-programming-together/
