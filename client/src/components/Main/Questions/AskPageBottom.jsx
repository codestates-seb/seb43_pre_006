import React from "react";
import styled from "styled-components";
import AskPageBottomArticle1 from "./AskPageBottomArticle1";
import AskPageBottomArticle2 from "./AskPageBottomArticle2";
import ToastEditor from "./ToastEditor";

export default function AskPageBottom() {
  return (
    <Container>
      <AskPageBottomArticle1 />
      <AskPageBottomArticle2 />
      <ToastEditor />
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  margin-top: 16px;

  & div:nth-of-type(3) {
    width: 70%;
  }
`;
