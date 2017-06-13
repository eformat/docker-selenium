# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# NOTE: DO *NOT* EDIT THIS FILE.  IT IS GENERATED.
# PLEASE UPDATE Dockerfile.txt INSTEAD OF THIS FILE
# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
FROM selenium/selenium-base
MAINTAINER Selenium <selenium-developers@googlegroups.com>

USER root
#==============
# VNC and Xvfb
#==============
# Install required RPMs
RUN yum repolist > /dev/null && \
    yum-config-manager --enable rhel-server-rhscl-7-rpms && \
    yum-config-manager --enable rhel-7-server-optional-rpms && \
    yum-config-manager --disable epel >/dev/null || : && \
    yum install -y xorg-x11-server-Xvfb && \
    yum clean all -y

#==============================
# Scripts to run Selenium Node
#==============================
COPY \
  entry_point.sh \
  functions.sh \
    /opt/bin/
RUN chmod +x /opt/bin/entry_point.sh

#============================
# Some configuration options
#============================
ENV SCREEN_WIDTH 1360
ENV SCREEN_HEIGHT 1020
ENV SCREEN_DEPTH 24
ENV DISPLAY :99.0

RUN chown -R jboss /opt/selenium
RUN chgrp -R 0 /opt/selenium
RUN chmod -R g+rw /opt/selenium

USER 185

CMD ["/opt/bin/entry_point.sh"]
