oc new-project selenium

git clone https://github.com/ddavison/selenium-openshift-templates.git
cd selenium-openshift-templates/
oc create -f selenium-hub.yaml
oc new-app --template selenium-hub
oc delete route selenium-hub
oc expose service selenium-hub

cd ..
git clone https://github.com/petenorth/docker-selenium.git
cd docker-selenium
oc new-app . --context-dir=NodeChrome -e=HUB_PORT_4444_TCP_ADDR=selenium-hub -e=HUB_PORT_4444_TCP_PORT=4444
oc create -f selenium-node-chrome-service.yaml 

