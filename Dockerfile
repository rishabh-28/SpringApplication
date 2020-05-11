FROM tomcat:latest
ADD ./target/SpringApp.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8885
CMD ["catalina.sh", "run"]
