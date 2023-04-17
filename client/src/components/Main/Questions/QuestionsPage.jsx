import React from "react";
import QuestionsTop from "./Top/QuestionsTop";
import styled from "styled-components";
import QuestionsBottom from "./Top/QuestionsBottom";

export default function QuestionsPage() {
  return (
    <Container>
      <QuestionsTop />
      <QuestionsBottom />
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: calc(100% - 300px - 24px);
`;
