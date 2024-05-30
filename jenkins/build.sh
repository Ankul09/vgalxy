#!/usr/bin/env bash

pushd ../
mvn clean package -DskipTests
popd
docker build -t devmj3/democicdapp ../
