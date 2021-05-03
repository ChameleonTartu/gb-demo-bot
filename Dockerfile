FROM azul/zulu-openjdk-alpine:11
ENV VERSION=1.0-SNAPSHOT
ENV SUFFIX=-jar-with-dependencies
ENV TOKEN=$TOKEN

COPY /target/gb-demo-bot-$VERSION$SUFFIX.jar /gb-demo-bot-$VERSION$SUFFIX.jar
CMD echo $TOKEN
CMD java -Djava.security.egd=file:/dev/./urandom -jar /gb-demo-bot-$VERSION$SUFFIX.jar $TOKEN
