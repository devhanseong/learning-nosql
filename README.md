# NoSQL 공부

## Mongodb

### Settings
1. mongodb Dockerfile 정의
2. Docker build image 
   - docker build -t mongo_image .
3. Docker run container
   -  docker run -d -p 27017:27017 --name mongo_container mongo_image
4. terminal 접속
   - 일반 계정 접속 : docker exec -it mongo_container mongosh
   - root 계정 접속 : docker exec -it mongo_container mongosh -u 계정 -p 패스워드
   
