FROM java:8

EXPOSE 8081

ADD /target/conta-corrente-ms.jar conta-corrente-ms.jar

ENTRYPOINT ["java","-jar","conta-corrente-ms.jar"]