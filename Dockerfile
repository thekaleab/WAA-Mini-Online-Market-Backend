########Maven build stage########
FROM maven:3.6-jdk-11 as maven_build
WORKDIR /app

#copy pom
COPY pom.xml .

#resolve maven dependencies
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/

#copy source
COPY src ./src

# build the app (no dependency download here)
# output name of the jar file is specified in pom.xml  currently set as 'waa_backend.jar'
RUN mvn clean package  -Dmaven.test.skip



FROM openjdk:17
WORKDIR /app
RUN mkdir /product_images
COPY --from=maven_build /app/target/waa_backend.jar ./app.jar  
ENTRYPOINT ["java","-jar","app.jar"]



# for debug purpose to keep the container polling
# ENTRYPOINT ["tail", "-f", "/dev/null"]
