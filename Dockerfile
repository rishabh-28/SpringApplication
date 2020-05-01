FROM tomcat:latest
ADD target/SpringApp.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
RUN echo "I am in!"
CMD ["catalina.sh", "run"]