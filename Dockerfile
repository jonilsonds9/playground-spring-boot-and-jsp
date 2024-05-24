FROM amazoncorretto:21-alpine

WORKDIR /app
# Instalando o `wget` e o `shadow` para poder criar um usuário e grupo
RUN apk add --no-cache wget shadow
RUN groupadd -r spring && useradd -r -g spring -s /sbin/nologin spring
RUN chown -R spring:spring /app

ARG WAR_FILE=target/*.war
COPY --chown=spring:spring ${WAR_FILE} playground.war

USER spring
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "playground.war"]