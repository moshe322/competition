From tomcat:8-alpine
COPY target/competition-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/competition-0.0.1-SNAPSHOT.war
EXPOSE 8080
