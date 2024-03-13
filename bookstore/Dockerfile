FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update --fix-missing && apt-get install -y maven

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean install -DskipTests

EXPOSE 2369

CMD ["java", "-jar", "target/bookstore-0.0.1-SNAPSHOT.jar"]