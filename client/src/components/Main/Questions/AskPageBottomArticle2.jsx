import React from "react";
import styled from "styled-components";
import AskPageBottomArticle2Left from "./AskPageBottomArticle2Left";
import AskPageBottomArticle2Right from "./AskPageBottomArticle2Right";

export default function AskPageBottomArticle2() {
  return (
    <Container>
      <AskPageBottomArticle2Left />
      <AskPageBottomArticle2Right />
    </Container>
  );
}

const Container = styled.div`
  display: flex;
`;
