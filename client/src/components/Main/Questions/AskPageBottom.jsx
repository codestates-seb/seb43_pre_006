import React from "react";
import styled from "styled-components";
import AskPageBottomArticle1 from "./AskPageBottomArticle1";
import AskPageBottomArticle2 from "./AskPageBottomArticle2";
import QuestionPageEditor from "./Bottom/Content/QuestionPageEditor";
import AskPageBottomArticle3 from "./AskPageBottomArticle3";

export default function AskPageBottom() {
  return (
    <Container>
      <AskPageBottomArticle1 />
      <AskPageBottomArticle2 />
      <AskPageBottomArticle3 />
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  margin-top: 16px;
`;
