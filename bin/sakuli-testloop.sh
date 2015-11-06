#!/bin/bash

export DISPLAY=:0.0
source ~/.bashrc
DIR=`dirname $0`
RUNFILE=$DIR/../suites.run

numargs=$#
for ((i=1 ; i <= numargs ; i++))
do
	case $1 in
		"--force-sakuli-update")
			FORCE_SAKULI_UPDATE=$1
			;;
		"--force-test-update")
			FORCE_TEST_UPDATE=$1
			;;
	esac
    	shift
done


if [ ! -r "$RUNFILE" ]; then
	echo "ERROR: $RUNFILE not found."
	exit 1
fi

$DIR/sakuli-install-latest.sh $FORCE_SAKULI_UPDATE
$DIR/sakuli-install-tests.sh $FORCE_TEST_UPDATE

for suite in $(cat $RUNFILE | grep -v '^#'); do 
	echo $suite
	$SAKULI_HOME/bin/sakuli.sh --run $SAKULI_HOME/../sakuli-examples/$suite --vnc
done 

