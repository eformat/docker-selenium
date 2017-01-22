    oc new-project selenium

Re-using ddavison git project for the hub template.

    git clone https://github.com/ddavison/selenium-openshift-templates.git
    cd selenium-openshift-templates/
    oc create -f selenium-hub.yaml
    oc new-app --template selenium-hub
    oc delete route selenium-hub
    oc expose service selenium-hub

Create the chrome node via a docker build using a Dockerfile and associated scripts that I have slightly modified. The fork is from the official selenium docker image git repo. 

    cd ..
    git clone https://github.com/petenorth/docker-selenium.git
    cd docker-selenium
    oc new-app . --context-dir=NodeChrome -e=HUB_PORT_4444_TCP_ADDR=selenium-hub -e=HUB_PORT_4444_TCP_PORT=4444
    oc create -f selenium-node-chrome-service.yaml 
    oc new-app . --context-dir=NodeFirefox -e=HUB_PORT_4444_TCP_ADDR=selenium-hub -e=HUB_PORT_4444_TCP_PORT=4444
    oc create -f selenium-node-firefox-service.yaml

Now run a simple JUnit test that using the Selenium RemoteWebDriver connecting to the Openshift hosted Selenium Hub.

    cd java-sample-selenium-grid
    mvn clean install
