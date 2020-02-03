https://www.confluent.io/blog/apache-kafka-spring-boot-application/

test

curl -X POST -F 'message=test' http://localhost:9000/kafka/publish

test JSON

 curl -X POST -F 'message={"foo": "fail"}' http://localhost:9000/kafka/publish-topic1