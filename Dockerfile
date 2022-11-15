FROM maven:3-openjdk-17-slim AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

FROM openjdk:17-slim
COPY --from=MAVEN_BUILD /build/target/*.jar /app.jar
WORKDIR /
ENTRYPOINT ["java","-jar","/app.jar"]