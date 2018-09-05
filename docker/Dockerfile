FROM openjdk:8-jre-alpine

ENV JAVA_OPTS="-XX:+HeapDumpOnOutOfMemoryError -Xmx512m -Xmx256m"
ENV ARANGO_HOST="localhost"
ENV ARANGO_PORT=8529
ENV ARANGO_USER="root"
ENV ARANGO_DBNAME="arango-demo"
ENV ARANGO_PASSWORD="null"
ENV CONCILIATOR_ENDPOINT="http://conciliator:8080/reconcile/"

ADD target/*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
