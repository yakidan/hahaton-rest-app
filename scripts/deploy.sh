#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp target/spring_boot-0.0.1-SNAPSHOT.jar \
    root@92.63.105.154:/root/java_prod


