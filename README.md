PWS Integration Demo
====================

Demo app that shows how to authenticate via PWS/UAAA and then accessing PWS rest apis.

This demo is based on the following:

- [Blog Article](https://content.pivotal.io/blog/how-to-integrate-an-application-with-cloud-foundry-using-oauth2)
- [OAuth2 Tutorial](https://spring.io/guides/tutorials/spring-boot-oauth2/)

Running With Real PWS / UAA
===========================

To integrate with PWS properly, you'll need a client-id and client-secret. This has to be
setup by someone with admin priviliges on PWS. 

This doesn't work yet.

Running with a Local UAA
========================

Start local UAA as follows

```
cd scripts
./start-uaa.sh 
```

Wait for a bit until UAA is up and running. Uaa will be accesible at http://localhost:8080/uaa. 
(In case you wanted to target it using `uaac`. You can also watch uaa logs (in a separate terminal)
using a command:

```
tail -f  /tmp/cargo/conf/logs/uaa.log
```

Now you can launch the demo app. It is a typical Spring Boot app. So one way to
launch it is by launching it from STS Boot Dashboard. Or you can run it from
a terminal as follows:

```
mvn clean package
java -jar target/*.jar
```

Open the app at http://localhost:8888/

Note: The local UAA has limited capabilities. It won't be possible to create a new user. But there
is a predefined test user. See `scripts/uaa.yml` for details.