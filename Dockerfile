FROM gradle:8.5.0-jdk17-alpine AS build
RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 9099

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/study_dev_ops_labs.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar","/app/study_dev_ops_labs.jar"]