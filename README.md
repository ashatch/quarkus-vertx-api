# quarkus-vertx-api project

Exploration of Quarkus.

## Bootstrap

```bash
brew install gu

mvn io.quarkus:quarkus-maven-plugin:1.8.1.Final:create \
    -DprojectGroupId=net.andrewhatch.quarkus-vertx-api \
    -DprojectArtifactId=quarkus-vertx-api \
    -DclassName="net.andrewhatch.quarkusvertx.api" \
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