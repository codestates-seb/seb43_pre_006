import React from "react";
import styled from "styled-components";
import AddAsk from "./AddAsk";

export default function QuestionsTop() {
  return (
    <Container>
      <h1>All Questions</h1>
      <AddAsk />
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 12px;

  > h2 {
    display: inline-block;
    font-size: 27px;
    font-weight: normal;
    line-height: 1.3rem;
  }
`;
