FROM maven:3.5.4-jdk-8-alpine as builder
RUN mkdir dropwizard-games
COPY ./ /dropwizard-games
WORKDIR dropwizard-games
RUN mvn clean install

FROM openjdk:8-jdk-alpine
COPY --from=builder /dropwizard-games/target/dropwizard-games-1.0.0.jar ./
COPY --from=builder /dropwizard-games/teams-docker-conf.yml ./

CMD java -jar dropwizard-games-1.0.0.jar db migrate teams-docker-conf.yml && java -jar dropwizard-games-1.0.0.jar server teams-docker-conf.yml
EXPOSE 8080
