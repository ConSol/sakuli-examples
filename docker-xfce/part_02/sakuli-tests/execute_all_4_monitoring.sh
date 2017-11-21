#!/usr/bin/env bash
cd $(dirname $0)

#stop command
stopLoop ()
{
kill -s SIGTERM $!
exit 0
}

trap stopLoop SIGINT SIGTERM

### run each suite every x seconds, until CTRL + C
SLEEP_SEC=5
while [ 1 ]
do
    docker-compose up --force-recreate --build
    wait $!
    echo "sleep $SLEEP_SEC seconds"
    sleep $SLEEP_SEC;
done
exit 0
