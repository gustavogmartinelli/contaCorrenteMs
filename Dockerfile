FROM java:8

EXPOSE 8081

ADD /target/conta-corrente-ms.war conta-corrente-ms.war

ENTRYPOINT ["java","-jar","conta-corrente-ms.war"]