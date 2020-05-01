FROM tomcat:latest
ADD target/cicd-pipeline-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
RUN echo "I am in!"
MAINTAINER "ssssssssssssssssssssssssssssss@gmail.com"
CMD ["catalina.sh", "run"]