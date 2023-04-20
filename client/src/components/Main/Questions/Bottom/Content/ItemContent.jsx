import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

export default function ItemContent({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));

  // 데인저러스 html

  return (
    <Container>
      <p>{question.content}</p>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;

  > p {
  }
`;
