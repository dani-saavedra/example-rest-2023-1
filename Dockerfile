FROM openjdk
COPY build/libs/demo-0.0.1-SNAPSHOT.jar miprograma.jar

ENTRYPOINT ["java", "-jar","/miprograma.jar"]