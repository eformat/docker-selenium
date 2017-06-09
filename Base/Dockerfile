FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
MAINTAINER Selenium <selenium-developers@googlegroups.com>

USER root

RUN yum install -y wget

# Add jboss user to the root group
RUN groupadd -r seluser -g 1000 && useradd -u 1000 -r -g seluser -m -d /home/seluser -s /sbin/nologin -c "Selenium user" seluser
RUN usermod -g root -G seluser seluser

#==========
# Selenium
#==========
RUN  mkdir -p /opt/selenium \
  && curl -o /opt/selenium/selenium-server-standalone.jar https://selenium-release.storage.googleapis.com/3.4/selenium-server-3.4.0.zip 

USER 1000
