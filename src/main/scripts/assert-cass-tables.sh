#!/usr/bin/env bash

cassandraContainer="cass3"
keyspace="k1"

echo "Waiting for the cassandra cluster..."
while ! docker exec -it ${cassandraContainer} cqlsh -e 'describe cluster' 2>&1>/dev/null ; do
  echo -e ".\c"
  sleep 2
done
echo " cluster up!"

echo "Asserting keyspace '${keyspace}' exists"
docker exec -it ${cassandraContainer} cqlsh -e \
  "CREATE KEYSPACE IF NOT EXISTS ${keyspace} WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}" \
  || echo "Failed to create keyspace"

echo "Asserting table 'bookmark' exists"
docker exec -it ${cassandraContainer} cqlsh -e \
  "CREATE TABLE IF NOT EXISTS ${keyspace}.bookmark(accountId text, folderId text, url text, label text, PRIMARY KEY((accountId), folderId, url))" \
  || echo "Failed to create table 'bookmark'"
