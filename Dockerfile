FROM openjdk:11
RUN mkdir /app

COPY /target/*.jar /app/almox.jar

CMD ["java","-Dspring.profiles.active=prod","-Duser.timezone=GMT-03:00", "-jar" ,"/app/almox.jar"]
