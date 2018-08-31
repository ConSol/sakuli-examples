# Demo setup to test Sakuli & check_mk

* `docker-compose up`
* Connect to https://localhost:8443, login to multisite (omdadmin/omd)
* On service "check_mk discovery" on host "localhost" click the icon **"edit services"** in the service action dropdown menu 
* on top of the list of found services, click on **"activate missing"** and save the config. This creates the found default checks initially.
* Back in the service list, on service "check_MK" on host "localhost" click the icon **"Rescheudle check"** in the service action dropdown menu. This will scan the local result file Sakuli will have written meanwhile. 
* Ensure that the service "sakuli_xfce" is OK 
