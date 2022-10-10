FROM maven:3.8.6-jdk-8

WORKDIR /cau1
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run