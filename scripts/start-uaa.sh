#!/bin/bash
set -e

if [ ! -f uaa.yml ]; then
	echo "Couldn't find uaa.yml"
	exit 99
fi

WORKDIR=$(pwd)

if [ ! -d ${HOME}/git/uaa ]; then
	cd ${HOME}/git
	git clone git@github.com:cloudfoundry/uaa.git
fi

cd ${HOME}/git/uaa
export CLOUD_FOUNDRY_CONFIG_PATH=${WORKDIR}
./gradlew clean assemble
./gradlew run
