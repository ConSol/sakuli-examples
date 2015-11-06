#!/bin/bash

source ~/.bashrc
RUNFILE=suites.run
RUNFILE=${1-$RUNFILE}

DIR=`dirname $0`


if [ ! -r "$RUNFILE" ]; then
	echo "ERROR: $RUNFILE not found."
	exit 1
fi

#$DIR/sakuli-install-latest.sh --force-update
#$DIR/sakuli-install-tests.sh

while read suite; do 
	echo $suite
	$SAKULI_HOME/bin/sakuli.sh --run $SAKULI_HOME/../sakuli-examples/$suite --vnc;
done <$RUNFILE

