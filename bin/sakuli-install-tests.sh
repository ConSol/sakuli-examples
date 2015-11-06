#!/bin/bash
clear 
source ~/.bashrc
GITURL="git@github.com:ConSol/sakuli-examples.git"

GIT=$(which git)
if [ ! -x "$GIT" ]; then 
	echo "> ERROR: GIT binary not found."
	exit 1; 
fi

# remove last slash
SAKULI_HOME=$(echo "$SAKULI_HOME" | sed 's#/$##')
SAKULI_INST=${SAKULI_HOME%/*}
if [ ! -d "$SAKULI_INST" ]; then 
	echo "> ERROR: Could not determine SAKULI_INST from SAKULI_HOME ($SAKULI_HOME)!"
	exit 1
fi

if [ ! -d $SAKULI_INST/sakuli-examples ]; then
	echo "> sakuli-examples not found; trying to clone from GitHub... "
	$GIT clone $GITURL
	if [ ! -d $SAKULI_INST/sakuli-examples ]; then 
		echo -n "> FAILED. Exiting."
		exit 1
	fi
fi 

cd $SAKULI_INST/sakuli-examples

echo "> Searching for changes on both sides..."

if (($(git status --porcelain | egrep "^(\?| ?M)" | wc -l))); then 
	echo "> Working copy is dirty (uncommitted changes). Commit and push first or remove the file(s). Leaving untouched."
	$GIT status
	exit 0
fi

$GIT remote update

LOCAL=$(git rev-parse @)
REMOTE=$(git rev-parse @{u})
BASE=$(git merge-base @ @{u})

# local - stage - remote
if [ $LOCAL = $REMOTE ]; then
	echo "> Working copy is up-to-date ($LOCAL)."
elif [ $REMOTE = $BASE ]; then
	echo "> Working copy contains committed changes. Push first, if possible, or reset everything with 'git reset --hard'. Leaving untouched and exiting. Details:"
	$GIT diff origin/master
	exit 0
elif [ $LOCAL = $BASE ]; then
	echo "> Working copy is out of date. Pulling from GitHub..."
	$GIT pull 
	LOCAL=$(git rev-parse @)
	REMOTE=$(git rev-parse @{u})
	if [ ! $LOCAL = $REMOTE ]; then
		echo " failed. Exiting."
		exit 1
	else 
		echo " successful."
		echo "> Working copy is up-to-date ($LOCAL)."
	fi
fi

