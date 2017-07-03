# This file is used to manage local images
# depending of the current dir and branch.
# Branch 'master' leads to no tag (=latest),
# others to "local/[dirname]:[branchname]

REPO = local/$(shell basename `pwd`)
TAG  = $(shell git rev-parse --abbrev-ref HEAD|sed 's/master/latest/')

IMAGE=$(REPO):$(TAG)

.PHONY: build start echo bash

up:
	# use the local base image with tag = branchname
	# local/omd-labs-centos-sakuli:github-204-docker-cloud
	sed 's@\(image:\) consol\(/omd-labs-.*\)@\1 local\2:$(TAG)@' docker-compose.yml > docker-compose.yml.local
	docker-compose -f docker-compose.yml.local up
	#@rm docker-compose.yml.local
start:
	docker run --name omd -p 8443:443 -d $(IMAGE)
startvol:
	docker run --name omd -d -p 8443:443         \
	-v $(shell pwd)/site/local:/omd/sites/$(SITENAME)/local \
	-v $(shell pwd)/site/etc:/omd/sites/$(SITENAME)/etc     \
	-v $(shell pwd)/site/var:/omd/sites/$(SITENAME)/var     \
	$(IMAGE)
echo:
	@echo $(IMAGE)
bash:
	docker run --name omd --rm -p 8443:443 -it $(IMAGE) /bin/bash
bashvol:
	docker run --name omd --rm -p 8443:443 -it \
	-v $(shell pwd)/site/local:/omd/sites/$(SITENAME)/local \
	-v $(shell pwd)/site/etc:/omd/sites/$(SITENAME)/etc     \
	-v $(shell pwd)/site/var:/omd/sites/$(SITENAME)/var     \
	$(IMAGE) /bin/bash
