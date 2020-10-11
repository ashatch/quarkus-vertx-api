.PHONY: build-fast-api-jvm
build-fast-api-jvm:
	@echo "+ $@"
	docker build -f src/main/docker/Dockerfile.fast-jar -t quarkus-vertx-api/api .

.PHONY: build-api-jvm
build-api-jvm:
	@echo "+ $@"
	docker build -f src/main/docker/Dockerfile.native -t quarkus-vertx-api/api .

start-cassandra:
	@echo "+ $@"
	cd src/main/docker-compose && docker-compose up -d
	./src/main/scripts/assert-cass-tables.sh

stop-cassandra:
	@echo "+ $@"
	cd src/main/docker-compose && docker-compose down

