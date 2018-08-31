# Beispiel-Setup OMD-Labs & Sakuli

## Initialisierung

    git clone git@gitlab.consol.de:meggle/omd-sakuli-gearmanpnp.git
    cd omd-sakuli-gearmanpnp
    docker-compose up

```    
docker ps
CONTAINER ID        IMAGE                                                   COMMAND                  CREATED             STATUS              PORTS                                                       NAMES
03e5f4e98794        consol/sakuli-centos-xfce:dev                           "/dockerstartup/st..."   2 minutes ago       Up 2 minutes        0.0.0.0:5901->5901/tcp, 0.0.0.0:6901->6901/tcp              sakulie2e
636dc57d0e68        consol/omd-labs-centos-sakuli:github-204-docker-cloud   "/root/start.sh"         3 minutes ago       Up 2 minutes        22/tcp, 80/tcp, 4730/tcp, 5666/tcp, 0.0.0.0:8443->443/tcp   omdlabs
```

## Zugriff

### OMD
**SSH**: `docker exec -it omdlabs bash`

**HTTP**: https://localhost:8443

### Sakuli
**SSH**: `docker exec -it sakuli bash`

**VNC**:
* vnc://localhost:5901
* http://localhost:6901
