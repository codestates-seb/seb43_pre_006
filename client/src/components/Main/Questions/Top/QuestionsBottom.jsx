import React, { useEffect, useState } from "react";
import styled from "styled-components";
import axios from "axios";
import { useRecoilState } from "recoil";
import { filterState } from "./../../../store/atom";
import FilterContainer from "./FilterContainer";

export default function QuestionsBottom() {
  const [listNum, setListNum] = useState(0);
  const [filterBox, setFilterBox] = useRecoilState(filterState);

  useEffect(() => {
    axios
      .get("http://localhost:8080/questions")
      .then((response) => {
        const data = response.data;
        const numQuestions = data.length;
        setListNum(numQuestions);
      })
      .catch((error) => {
        console.log(error);
      });
  });

  return (
    <Container>
      <div className="numQuestions">{listNum} questions</div>
      <FilterBox>
        <BtnBox>
          <StyledButton>Newest</StyledButton>
          <StyledButton>Active</StyledButton>
          <StyledButton>Bountied</StyledButton>
          <StyledButton>Unanswered</StyledButton>
          <StyledButton>More</StyledButton>
        </BtnBox>
        <Filter onClick={() => setFilterBox(!filterBox)}>
          <svg
            aria-hidden="true"
            class="svg-icon iconFilter"
            width="18"
            height="18"
            viewBox="0 0 18 18"
          >
            <path d="M2 4h14v2H2V4Zm2 4h10v2H4V8Zm8 4H6v2h6v-2Z"></path>
          </svg>
          Filter
        </Filter>
      </FilterBox>
      {filterBox && <FilterContainer />}
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: solid 1px ${({ theme }) => theme.black100};
  padding-bottom: calc(12px * 1);

  > .numQuestions {
    font-size: 17px;
    margin-right: calc(12px * 1);
    color: ${({ theme }) => theme.black900};
    font-weight: 400;
  }
`;

const FilterBox = styled.div`
  display: flex;
`;

const BtnBox = styled.div`
  margin-right: calc(16px * 1);
  display: flex;
  border: solid 1px gray;
  border-radius: 4px;

  > button:first-child {
    border-radius: 4px 0 0 4px;
  }

  > button:last-child {
    border-radius: 0 4px 4px 0;
    border-right: none;
  }
`;

const Filter = styled.button`
  display: flex;
  background-color: #ffffff;
  border: none;
  padding: 10px;
  border: solid 1px ${({ theme }) => theme.blue400};
  color: ${({ theme }) => theme.blue600};
  background-color: ${({ theme }) => theme.powder100};
  border-radius: 4px;
  cursor: pointer;
  align-items: center;

  > svg {
    margin-bottom: 1px;
    margin-right: 3px;
    fill: currentColor;
  }

  &:hover {
    color: ${({ theme }) => theme.blue700};
  }
`;

const StyledButton = styled.button`
  background-color: #ffffff;
  border: none;
  padding: 10px;
  border-right: solid 1px gray;
  cursor: pointer;
  color: ${({ isSelected, theme }) =>
    isSelected ? theme.black700 : theme.black500};

  &:last-child {
    border-right: none;
  }

  &:hover {
    background-color: ${({ theme }) => theme.black100};
  }
`;