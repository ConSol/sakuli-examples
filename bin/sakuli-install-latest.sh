#!/bin/bash
clear

# FIXME: compare MD5 sum on labs.consol.de to only download ZIP when needed

URL="https://labs.consol.de/sakuli/install/sakuli-v0.9.2-SNAPSHOT.zip"
VERSION=$(echo $URL | sed -e 's/.zip$//' -e 's/.*\/\(sakuli-.*$\)/\1/')
DOWNLOAD=/tmp
FORCE_UPDATE=$1

# remove last slash
SAKULI_HOME=$(echo "$SAKULI_HOME" | sed 's#/$##')
SAKULI_INST=${SAKULI_HOME%/*}
if [ ! -d "$SAKULI_INST" ]; then 
	echo "ERROR: Could not determine SAKULI_INST from SAKULI_HOME ($SAKULI_HOME)!"
	exit 1
fi

# new version available? 
# - download latest version
echo "> Removing old downloads..."
cd $DOWNLOAD
rm -rf sakuli*

echo "> Downloading latest Sakuli version..."
wget $URL
echo "> Unzipping..."
unzip -q ${VERSION}.zip
if [ -d $SAKULI_INST/$VERSION ]; then 
	echo "> Directory "
fi
echo "> Installing..."
if [ "$FORCE_UPDATE" -eq "--force-update" ]; then 
	read -p "> Directory $SAKULI_INST/$VERSION already exists. Remove? (y/n)" answer
	if [ $answer != "y" ]; then 
		echo "Aborted by user."
		exit 1
	fi
fi
rm -rf $SAKULI_INST/$VERSION
mv -v sakuli/$VERSION $SAKULI_INST/
chmod +x $SAKULI_INST/$VERSION/bin/sakuli.sh

echo -n "> Updating environment..."
sed -i "s@\\(export SAKULI_HOME=\\).*@\\1$SAKULI_INST/$VERSION@" ~/.bashrc
source ~/.bashrc

if [ "$SAKULI_INST/$VERSION" == "$SAKULI_HOME" ]; then 
	echo " succeeded."
else
	echo " FAILED! SAKULI_HOME still points to the old installation. Please check!"
fi

if [ ! -d $SAKULI_INST/sahi ]; then
	echo "No Sahi installation detected. Remember to install!"
fi

exit 0
