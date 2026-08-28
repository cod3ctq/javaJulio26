FROM eclipse-temurin:17-jdk-alpine
COPY "./target/ms-cuentas-0.0.1-SNAPSHOT.jar" "app.jar" 
EXPOSE 8090 
ENTRYPOINT ["java","-jar","app.jar"] 

#8090 es el puerto del proyecto que se expone