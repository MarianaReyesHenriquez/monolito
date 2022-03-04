#
#Build stage
#
FROM maven:3.8.4-jdk-11 AS build
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/app/pom.xml clean package
#
#Packet stage
#
FROM openjdk:11
ENV PROFILE local
COPY --from=build /usr/app/target/monolito-0.0.1-SNAPSHOT.jar /usr/app/monolito.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/monolito.jar", "--spring.profiles.active=${PROFILE}"]
