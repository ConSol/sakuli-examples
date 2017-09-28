# Sakuli Selenium Integration Example

This is an example Project-Setup to integrate [Selenium](https://www.selenium.org) with your Sakuli Tests.

Chrome Driver: https://sites.google.com/a/chromium.org/chromedriver/downloads

**General note:** If you get the exception `java.nio.file.AccessDeniedException: /opt/test/example_xfce/_logs` please ensure that you local files have the correct file permissions. If you not sure you can run `chmod a+rw -R .` or change `user: 1000` to your own user id (execute `id -u`).
