FROM tomcat:latest
ADD ./target/SpringApp.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8885
RUN sed -i 's/port="8080"/port="8885"/' /usr/local/tomcat/conf/server.xml
CMD ["catalina.sh", "run"]
