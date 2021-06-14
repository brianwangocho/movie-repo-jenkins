FROM openjdk:8
ADD target/docker-movie-image.jar docker-movie-image.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","docker-movie-image.jar"]