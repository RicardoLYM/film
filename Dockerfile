FROM java:8
VOLUME /tmp
ADD target/*.jar film.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/film.jar"]


