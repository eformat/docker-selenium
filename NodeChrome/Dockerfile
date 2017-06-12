# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# NOTE: DO *NOT* EDIT THIS FILE.  IT IS GENERATED.
# PLEASE UPDATE Dockerfile.txt INSTEAD OF THIS FILE
# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
FROM selenium/node-base
MAINTAINER Selenium <selenium-developers@googlegroups.com>

USER root

#============================================
# Google Chrome
#============================================
# can specify versions by CHROME_VERSION;
#  e.g. google-chrome-stable=53.0.2785.101-1
#       google-chrome-beta=53.0.2785.92-1
#       google-chrome-unstable=54.0.2840.14-1
#       latest (equivalent to google-chrome-stable)
#       google-chrome-beta  (pull latest beta)
#============================================

RUN yum-config-manager --enable rhel-7-desktop-optional-rpms

ARG CHROME_VERSION="google-chrome-stable"
RUN curl -L -o google-chrome-stable_current_x86_64.rpm https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm && \
    yum -y localinstall google-chrome-stable_current_x86_64.rpm

#  yum -y install redhat-lsb libXScrnSaver

#==================

#==================
# Chrome webdriver
#==================
ARG CHROME_DRIVER_VERSION=2.30
RUN wget --no-verbose -O /tmp/chromedriver_linux64.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
  && rm -rf /opt/selenium/chromedriver \
  && unzip /tmp/chromedriver_linux64.zip -d /opt/selenium \
  && rm /tmp/chromedriver_linux64.zip \
  && mv /opt/selenium/chromedriver /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION \
  && chmod 755 /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION \
  && ln -fs /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION /usr/bin/chromedriver


#========================
# Selenium Configuration
#========================
ENV NODE_MAX_INSTANCES 1
ENV NODE_MAX_SESSION 1
ENV NODE_REGISTER_CYCLE 5000
ENV NODE_PORT 5555
RUN echo export CHROME_VERSION=$( rpm -q chromedriver  ) > /opt/selenium/browser_version.sh
RUN chmod +x /opt/selenium/browser_version.sh
COPY generate_config /opt/selenium/generate_config
RUN chmod +x /opt/selenium/generate_config

#=================================
# Chrome Launch Script Modication
#=================================
COPY chrome_launcher.sh /opt/google/chrome/google-chrome
RUN chmod +x /opt/google/chrome/google-chrome
RUN chown -R seluser:seluser /opt/selenium
RUN chgrp -R 0 /opt/selenium
RUN chmod -R g+rw /opt/selenium

RUN chgrp -R 0 /home/jboss
RUN chmod -R g+rw /home/boss


USER 1000
# Following line fixes
# https://github.com/SeleniumHQ/docker-selenium/issues/87
ENV DBUS_SESSION_BUS_ADDRESS=/dev/null
