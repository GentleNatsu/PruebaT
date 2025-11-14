#FROM docker.artifactory.gcp.mercadona.com/custom/springboot-java:17-jre-alpine-v4
FROM eclipse-temurin:21-jdk

COPY boot/target/pruebat-back-web-base-boot-0.0.0.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080



#ARG DEPENDENCY=target/dependency
#
## Add layers which may be cached
#COPY ${DEPENDENCY}/org ./org
#COPY ${DEPENDENCY}/BOOT-INF/lib ./BOOT-INF/lib
#
## Add new layers
#COPY ${DEPENDENCY}/META-INF ./META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes ./BOOT-INF/classes


