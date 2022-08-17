FROM openjdk:11
COPY ./build/libs/cryptocurrencywatcher-0.0.1-SNAPSHOT.jar watcherapp.jar
ENTRYPOINT ["java","-jar","watcherapp.jar"]