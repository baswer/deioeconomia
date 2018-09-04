FROM tomcat:latest
VOLUME /tmp
COPY target/deioeconomia-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
RUN sh -c 'touch /app.war'
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war"]
ENV JPDA_ADDRESS 8000
CMD ["catalina.sh", "jpda", "run"]