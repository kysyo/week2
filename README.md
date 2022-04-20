# Say Hello Server

4-19 일 과제 추가
  - 클라이언트를 사용해서 내부호출 구현
  - Info-Server를 호출해 Job 데이터를 받아 response에 추가

(Request)
http://localhost:8080/hello?name=$name

(Response)
{
"to": "$name",
"message": "hello$name",
"job": "Developer"
}
