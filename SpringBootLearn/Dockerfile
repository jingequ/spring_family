FROM java:8
EXPOSE 8080
ARG JAR_FILE
ADD target/${JAR_FILE} /springbootlearnDemo.jar
ENTRYPOINT ["java", "-jar", "/springbootlearnDemo.jar"]