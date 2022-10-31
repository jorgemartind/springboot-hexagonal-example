FROM maven:3-openjdk-18

WORKDIR /rate-backend
COPY . .
RUN mvn clean install

CMD mvn -pl boot spring-boot:run