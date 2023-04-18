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
  display: flex;
  padding: 16px;
  font-size: 13px;
  border-top: solid 1px ${({ theme }) => theme.black100};

  > .left {
    width: 108px;
    display: flex;
    flex-direction: column;
    flex-shrink: 0;
    margin: 0 16px 4px 0;
    text-align: right;
  }

  > .right {
    display: flex;
    flex-direction: column;
    padding-right: 24px;

    > a {
      color: ${({ theme }) => theme.blue600};
      margin: -2px 0 5px;
      font-size: 17px;
      font-weight: 400;
      text-decoration: none;
      border: solid 1px ${({ theme }) => theme.orange200};
    }

    > span {
      hyphens: auto !important;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      overflow: hidden;
      word-break: break-word !important;
      overflow-wrap: break-word !important;
      margin-bottom: 8px;
    }
  }
`;
