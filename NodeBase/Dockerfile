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
#RUN yum-config-manager --enable rhel-7-server-optional-rpms \
#  && yum install -y xorg-x11-server-Xvfb
#RUN yum install -y xorg-x11-server-Xvfb

# Install required RPMs
RUN yum install -y --disablerepo=\* --enablerepo=jboss-rhel-rhscl --enablerepo=jboss-rhel-os --enablerepo=jboss-rhel-ose --enablerepo=jboss-rhel-optional xorg-x11-server-Xvfb \
    && yum clean all

# Remove custom repo files
RUN rm /etc/yum.repos.d/jboss-rhel-rhscl.repo /etc/yum.repos.d/jboss-rhel-os.repo /etc/yum.repos.d/jboss-rhel-ose.repo /etc/yum.repos.d/jboss-rhel-optional.repo


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

RUN chown -R seluser /opt/selenium
RUN chgrp -R 0 /opt/selenium
RUN chmod -R g+rw /opt/selenium

USER 1000

CMD ["/opt/bin/entry_point.sh"]
