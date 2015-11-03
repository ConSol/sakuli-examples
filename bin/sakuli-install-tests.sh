#!/bin/bash

$GIT=$(which git)
if [ ! -x "$GIT" ]; then 
	echo "ERROR: GIT binary not found."
	exit 1; 
fi
if [ ! -d "$SAKULI_HOME" ]; then 
	echo "ERROR: $SAKULI_HOME does not exist!"
	exit 1
fi


SAKULI_INST=$SAKULI_HOME/../
