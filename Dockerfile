FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-credit.jar
ENTRYPOINT ["java","-jar","/ms-credit.jar"]