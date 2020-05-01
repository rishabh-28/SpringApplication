FROM tomcat:latest
ADD ./target/devopsDemo.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
