import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

export default function QuestionItem({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));

  return (
    <Container>
      <h1>{question.title}</h1>
      <p>{question.content}</p>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  justify-content: center;
  margin-top: 50px;
  width: calc(100% - 164px);
  max-width: 1100px;
  padding: calc(24px * 1);
`;
