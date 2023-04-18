import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
// import { StacksEditor } from "@stackoverflow/stacks-editor";
// import "@stackoverflow/stacks-editor/styles.css";

export default function ItemContent({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));

  return (
    <Container>
      <p>{question.content}</p>
      {/* <StacksEditor container="#editor-container" initialValue="Hello World!" /> */}
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;

  > p {
  }
`;
