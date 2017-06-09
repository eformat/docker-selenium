FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
MAINTAINER Selenium <selenium-developers@googlegroups.com>

USER root

# Add jboss user to the root group
RUN groupadd -r seluser -g 1000 && useradd -u 1000 -r -g seluser -m -d /home/seluser -s /sbin/nologin -c "Selenium user" seluser
RUN usermod -g root -G seluser seluser

#==========
# Selenium
#==========
RUN  mkdir -p /opt/selenium \
  && wget --no-verbose https://selenium-release.storage.googleapis.com/3.0/selenium-server-standalone-3.0.1.jar -O /opt/selenium/selenium-server-standalone.jar

USER 1000
