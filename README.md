# myplanner
implement crud in backend

DB: Docker 위의 Mysql image

사용언어(kotlin) 

frontend 부분 : https://github.com/touch2020/myplanner-frontend (사용언어:react)

spring boot로 planner backend 구현,
jsoup라이브러리를 이용한 에브리타임 시간표 크롤링이후 DB에 필요한 데이터 저장,  
react 이용해서 사용자가 DB에 추가한 오늘 계획을 보여주고 
크롤링한 시간표 데이터를 뿌려주는 front부분 구현중

1.오늘 할일을 보여주는 화면

![할일 추가](https://user-images.githubusercontent.com/64405110/126056348-0de29db7-0004-4ecc-8896-e3fc27e6077f.PNG)

2.사용자가 에브리타임 연동시 오늘 있는 수업을 출력

![오늘 수업 출력](https://user-images.githubusercontent.com/64405110/126056372-db11673d-0430-459b-b97c-234dd29bd66b.PNG)


*구현해야 할것 (==>7/30 완료)

(1).사용자에게 에브리타임 아이디와 비밀번호를 입력하게 하는 화면

(2).그 데이터를 백엔드에서 로그인 처리하는 부분(지금은 하드코딩으로 내 아이디를 넣어놓았다)



2021/7/30

로그인 정보를 사용자에게 입력받아서 백엔드에 전달

![로그인 추가](https://user-images.githubusercontent.com/64405110/127597011-83eb6106-1899-4d1d-8e99-8ee6795c80a2.PNG)









