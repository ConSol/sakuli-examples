FROM consol/sakuli-ubuntu-xfce-java:v1.1.0-beta

MAINTAINER Tobias Schneck "tobias.schneck@consol.de"
ENV REFRESHED_AT 2017-04-26

ENV SEL_DRIVER $HOME/seleniumdriver
RUN mkdir $SEL_DRIVER && cd $SEL_DRIVER \
    && wget https://chromedriver.storage.googleapis.com/2.25/chromedriver_linux64.zip \
    && unzip *.zip && rm *.zip && ls -la
