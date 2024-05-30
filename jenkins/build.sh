#!/usr/bin/env bash

pushd ../
mvn clean package -DskipTest
popd
docker build -t devmj3/democicdapp ../
