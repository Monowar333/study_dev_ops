FROM gradle:8.5.0-jdk17-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src/study_dev_ops_labs
WORKDIR /home/gradle/src/study_dev_ops_labs
RUN gradle bootJar --no-daemon --stacktrace
FROM openjdk:17-jdk-slim

EXPOSE 9099
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/study_dev_ops_labs/build/libs/*.jar study_dev_ops_labs.jar
ENTRYPOINT ["java","-jar","/study_dev_ops_labs.jar"]