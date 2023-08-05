#!/bin/sh

docker build -t sandbox-0.0.1 .  

docker image prune -fa # to remove all images

docker-compose up

docker-compose down
