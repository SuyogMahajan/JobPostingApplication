FROM azul/zulu-openjdk:21-latest
VOLUME /tmp
COPY "/target/SpringBootRest-0.0.1-SNAPSHOT.jar" app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]