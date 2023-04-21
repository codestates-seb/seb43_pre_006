import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

export default function ItemTop({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));

  return (
    <Container>
      <span className="title">{question.title}</span>
      <div className="sub">
        <span>Asked today</span>
        <span>Modified today</span>
        <span>Viewd {question.viewCount} times</span>
      </div>
    </Container>
  );
}

const Container = styled.div`
  > .title {
    display: block;
    font-size: 27px;
    margin-bottom: 8px;
  }

  > .sub {
    > span {
      display: inline-block;
      margin-right: 16px;
      margin-bottom: 8px;
      font-size: 13px;
      color: ${({ theme }) => theme.black300};
    }
  }
`;
