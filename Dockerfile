FROM openjdk:8
COPY . /app
WORKDIR /app
RUN ./gradlew assemble
CMD [ "./gradlew", "bootRun" ]
EXPOSE 5204