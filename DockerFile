# 기본 이미지 선택
FROM openjdk:17

# 애플리케이션의 실행 가능 JAR 파일을 컨테이너 내부로 복사
COPY build/libs/PortfoiloAPI-0.0.1-SNAPSHOT-plain.jar app.jar
# 컨테이너가 시작될 때 실행될 명령어 지정
ENTRYPOINT ["java","-jar","app.jar"]