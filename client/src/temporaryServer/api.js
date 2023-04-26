const express = require("express");
const cors = require("cors");
const { v4: uuidv4 } = require("uuid");

const app = express();
// id 고유값 부여
const corsOptions = {
  origin: "http://localhost:3000", // 허용할 도메인
  optionsSuccessStatus: 200,
  credential: true,
};
app.use(cors(corsOptions));
// cors 접근 설정

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.listen(8080, () => {
  console.log("Server listening on port 8080");
});

const List = {
  data: [
    {
      questionId: 13,
      title: "안녕",
      content:
        "<p><code>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅁㄴㅇㅁㄴㅇ</code><strong><code>ㅁㄴㅇㅁㄴㅇ</code></strong></p>",
      createdAt: "2023-04-19T18:33:15",
      modifiedAt: "2023-04-19T18:48:43",
      likeCount: 3,
      viewCount: 4,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 12,
      title: "Javascript 변수",
      content: "자바스크립트에서 변수를 선언하는 방법은 무엇인가요?",
      createdAt: "2023-04-04T17:20:00",
      modifiedAt: "2023-04-20T07:30:00",
      likeCount: 5,
      viewCount: 10,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 11,
      title: "Spring Security",
      content: "Spring Security를 이용한 로그인 기능 구현",
      createdAt: "2023-04-06T00:00:00",
      modifiedAt: "2023-04-20T04:10:00",
      likeCount: 0,
      viewCount: 1,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 10,
      title: "인사",
      content: "안녕하세요? 누구세요?",
      createdAt: "2023-04-07T03:50:00",
      modifiedAt: "2023-04-20T02:20:00",
      likeCount: 3,
      viewCount: 9,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 9,
      title: "Python list",
      content: "Python에서 list를 생성하는 방법은 무엇인가요?",
      createdAt: "2023-04-07T18:00:00",
      modifiedAt: "2023-04-19T20:30:00",
      likeCount: 1,
      viewCount: 6,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 8,
      title: "운동",
      content: "오늘의 운동은 무엇을 하셨나요?",
      createdAt: "2023-04-08T23:40:00",
      modifiedAt: "2023-04-20T03:30:00",
      likeCount: 0,
      viewCount: 3,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 7,
      title: "Javascript",
      content: "Javascript에서 null과 undefined의 차이점은 무엇인가요?",
      createdAt: "2023-04-09T20:15:00",
      modifiedAt: "2023-04-19T18:30:00",
      likeCount: 0,
      viewCount: 2,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 6,
      title: "Spring Boot",
      content: "Spring Boot를 이용한 웹 어플리케이션 개발",
      createdAt: "2023-04-11T05:30:00",
      modifiedAt: "2023-04-19T21:00:00",
      likeCount: 2,
      viewCount: 7,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 5,
      title: "인사",
      content: "오늘은 뭐하고 지내셨나요?",
      createdAt: "2023-04-12T22:00:00",
      modifiedAt: "2023-04-20T01:00:00",
      likeCount: 1,
      viewCount: 3,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
    {
      questionId: 4,
      title: "저녁 메뉴",
      content: "오늘 저녁에 뭐 먹을까요?",
      createdAt: "2023-04-15T04:10:00",
      modifiedAt: "2023-04-20T00:40:00",
      likeCount: 2,
      viewCount: 3,
      userName: null,
      userEmail: null,
      commentOfQuestions: [],
    },
  ],
  pageInfo: {
    page: 1,
    size: 10,
    totalElements: 12,
    totalPages: 2,
  },
};

app.get("/questions", (req, res) => {
  return res.json(List);
});
