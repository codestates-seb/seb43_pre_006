import React from "react";
import styled from "styled-components";
import { List } from "./ExampleList";
import { Link } from "react-router-dom";

export default function QuestionsList() {
  const list = List.data;
  return (
    <>
      {list.map((el, idx) => (
        <Container key={idx}>
          <div className="left">
            <span>{el.score} votes</span>
            <span>{el.answers.length} answers</span>
            <span>{el.viewCount} views</span>
          </div>
          <div className="right">
            <Link to={`/questions/${el.questionId}`}>{el.title}</Link>
            <span>{el.content}</span>
          </div>
        </Container>
      ))}
    </>
  );
}

const Container = styled.div`
  border-top: solid 1px ${({ theme }) => theme.black100};
  display: flex;
  padding: 16px;
  font-size: 13px;

  > .left {
    display: flex;
    flex-direction: column;
    margin: 0 16px 4px 0;
    text-align: right;
    width: 108px;
  }

  > .right {
    display: flex;
    flex-direction: column;
    padding-right: 24px;

    & Link {
      font-size: 17px;
      text-decoration: none;
    }
  }
`;
