FROM openjdk:17-jdk-alpine
ADD target/projet-angular.jar projet-angular.jar
ENTRYPOINT ["java","-jar","projet-angular.jar"]