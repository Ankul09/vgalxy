#!/usr/bin/env bash

mvn clean package -DskipTest
docker build -t devmj3/democicdapp ../
