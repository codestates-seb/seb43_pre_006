import React from "react";
import QuestionsTop from "./Top/QuestionsTop";
import styled from "styled-components";
import QuestionsBottom from "./Top/QuestionsBottom";
import FilterContainer from "./Top/Filter/FilterContainer";
import { filterState } from "./../../store/atom";
import { useRecoilValue } from "recoil";
import QuestionsList from "./Bottom/QuestionsList";

export default function QuestionsPage() {
  const filterBtn = useRecoilValue(filterState);

  return (
    <Container>
      <QuestionsContainer>
        <QuestionsTop />
        <QuestionsBottom />
        {filterBtn && <FilterContainer />}
      </QuestionsContainer>
      <QuestionsList />
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: calc(100% - 300px - 24px);
`;

const QuestionsContainer = styled.div`
  display: flex;
  flex-direction: column;
`;
