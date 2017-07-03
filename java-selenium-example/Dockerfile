#TODO change version after release
FROM consol/sakuli-ubuntu-xfce-java:v1.1.0-SNAPSHOT-247_sakuli_se


MAINTAINER Tobias Schneck "tobias.schneck@consol.de"
ENV REFRESHED_AT 2017-07-02

ENV SEL_DRIVER $HOME/seleniumdriver
RUN mkdir $SEL_DRIVER && cd $SEL_DRIVER \
    && wget https://chromedriver.storage.googleapis.com/2.25/chromedriver_linux64.zip \
    && unzip *.zip && rm *.zip && ls -la

USER 0
RUN apt-get update \
    && apt-get install -y gedit \
    && apt-get clean -y
USER 1000