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
   
### CLI

#### 데이터 베이스 목록 조회
show dbs;

#### 데이터 베이스 변경
use 데이터베이스명;

#### 현재 데이터 베이스 확인
db;

#### 컬렉션 생성
db.createCollection("컬렉션 명");

```
test> db.createCollection("persons")
{ ok: 1 }
```

#### 컬렉션 목록 확인
show collections;

#### 단일 Document 삽입
db.컬렉션명.insertOne({key:value});

```
test> db.persons.insertOne({name:"dev", age:20})
{
  acknowledged: true,
  insertedId: ObjectId('6785f2c4523838c193544ca7')
}
```
#### 여러 Document 삽입
db.컬렉션명.insertMany([{key:value}]);

```
test> db.persons.insertMany([{name:"bae", age:21}, {name:"hanseong", age:22}])
{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('6785f2dd523838c193544ca8'),
    '1': ObjectId('6785f2dd523838c193544ca9')
  }
}
```
#### 모든 Document 조회
db.컬렉션명.find();

```
test> db.persons.find()
[
  { 
    _id: ObjectId('6785f2c4523838c193544ca7'),
    name: 'dev',
    age: 20
  },
  { 
    _id: ObjectId('6785f2dd523838c193544ca8'),
    name: 'bae',
    age: 21
  },
  {
    _id: ObjectId('6785f2dd523838c193544ca9'),
    name: 'hanseong',
    age: 22
  }
]

```
#### 컬렉션 문서 수 확인
db.컬렉션명.countDocuments()

#### 특정 조건으로 Document 조회
db.컬렉션명.find({key:value})

```
test> db.persons.find({name : "hanseong"})
[
  {
    _id: ObjectId('6785f2dd523838c193544ca9'),
    name: 'hanseong',
    age: 22
  }
]

```

#### 단일 Document 업데이트
db.컬렉션명.updateOne({filter_key : filter_value}, {$set: {key : value}})

```
test> db.persons.updateOne({name : "dev"}, {$set: {name : "develop"}})
{
  acknowledged: true,
  insertedId: null,
  matchedCount: 1,
  modifiedCount: 1,
  upsertedCount: 0
}

```
#### 단일 Document 삭제
db.컬렉션명.deleteOne({key : value})
```
test> db.persons.deleteOne({name : "bae"})
{ acknowledged: true, deletedCount: 1 }
```

#### 여러 Document 삭제
db.컬렉션명.deleteMany({key:value})

#### 컬렉션 삭제
db.컬렉션명.drop()
```
test> db.persons.drop()
true
```
#### 데이터베이스 삭제
db.dropDatabase()