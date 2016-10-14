FROM consol/ubuntu-xfce-vnc:1.0.1
MAINTAINER Tobias Schneck "tobias.schneck@consol.de"
ENV REFRESHED_AT 2016-10-13

ENV VNC_COL_DEPTH 24
ENV VNC_RESOLUTION 1280x1024
ENV VNC_PW sakuli

### Install some basic libs and JDK8 (first remove some wrong cache files)
RUN rm -rf /var/lib/apt /etc/apt/sources.list.d/mint.list && apt-get update && \
    apt-get install -y --no-install-recommends software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer oracle-java8-set-default maven && \
    rm -rf /var/lib/apt
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

#### Install some native libaries for Sakuli
RUN apt-get update \
    && apt-get -y install --fix-missing libcv2.4 libtesseract3 wmctrl xdotool psmisc \
    && rm -rf /var/lib/apt/

### Add custom startup hook to correct the file permissions after running a test
ADD start_hook.sh /root/scripts/
RUN chmod +x /root/scripts/start_hook.sh
ENTRYPOINT ["/root/scripts/start_hook.sh"]