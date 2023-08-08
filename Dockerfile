FROM maven:3.6.3-jdk-11-openj9 as builder
WORKDIR /app
COPY . .
#COPY serviceAccountKey.json .
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src
#COPY pom.xml .
#RUN --mount=type=cache,target=/root/.m2,rw ./mvnw -B package

#FROM openjdk:11-jre-slim-buster

#COPY --from=build /app/target/deploy**.jar /api.jar

#EXPOSE 9000
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dcom.sun.net.ssl.checkRevocation=false","-Dserver.port=9000","-jar", "api.jar"]
ENTRYPOINT ["mvn","test"]