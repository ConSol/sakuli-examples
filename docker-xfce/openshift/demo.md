# logins
    oc login https://api.preview.openshift.com
    oc login https://cvm14106.osp.consol.de:8443

# delete all
    oc delete all --all

# create new run config
    oc process -f openshift.sakuli.example.pod.run.yaml -v E2E_TEST_NAME=oop2017 | oc create -f -

    oc process -f openshift.sakuli.example.job.run.yaml -v E2E_TEST_NAME=oop2017-job | oc create -f 

# connect
HTML route + `?password=sakuli&view_only=true`

