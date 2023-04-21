import React, { useEffect, useState } from "react";
import styled from "styled-components";
import axios from "axios";
import { useRecoilState } from "recoil";
import { filterState } from "./../../../store/atom";
import { Link, useLocation, useParams } from "react-router-dom";

export default function QuestionsBottom() {
  const [listNum, setListNum] = useState(0);
  const [filterBox, setFilterBox] = useRecoilState(filterState);

  const location = useLocation(); // URL
  const path = location.pathname;
  // 주소값 가져오기
  const searchParams = new URLSearchParams(location.search); // 쿼리 스트링을 읽을 수 있다.
  const tab = searchParams.get("tab"); // localhost:3000/questions?"tab"=Active&page=3
  const isTabActive = tab === "Active"; //ture or false
  const isTabBountied = tab === "Bountied";
  const isTabUnanswered = tab === "Unanswered";
  const isTabNewest = !tab;

  // 쿼리 스트링 가져오기 찾아보기

  useEffect(() => {
    axios
      .get(
        "https://5517-124-111-225-247.ngrok-free.app/questions?page=1&size=10",
        {
          headers: {
            "Content-Type": "application/json",
            "ngrok-skip-browser-warning": "69420",
          },
        }
      )
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
          <StyledButton isSelected={isTabNewest}>
            <Link to="/">Newest</Link>
          </StyledButton>
          <StyledButton isSelected={isTabActive}>
            <Link to="/?tab=Active">Active</Link>
          </StyledButton>
          <StyledButton isSelected={isTabBountied}>
            <Link to="/?tab=Bountied">Bountied</Link>
          </StyledButton>
          <StyledButton isSelected={isTabUnanswered}>
            <Link to="/?tab=Unanswered">Unanswered</Link>
          </StyledButton>
          <StyledButton>More</StyledButton>
        </BtnBox>
        <Filter onClick={() => setFilterBox(!filterBox)}>
          <svg
            aria-hidden="true"
            className="svg-icon iconFilter"
            width="18"
            height="18"
            viewBox="0 0 18 18"
          >
            <path d="M2 4h14v2H2V4Zm2 4h10v2H4V8Zm8 4H6v2h6v-2Z"></path>
          </svg>
          Filter
        </Filter>
      </FilterBox>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
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
  background-color: ${({ isSelected, theme }) =>
    isSelected ? theme.black200 : "#ffffff"};
  border: none;
  padding: 10px;
  border-right: solid 1px gray;
  cursor: pointer;

  > a {
    text-decoration: none;
    color: ${({ isSelected, theme }) =>
      isSelected ? theme.white : theme.black500};
  }

  &:last-child {
    border-right: none;
  }

  &:hover {
    background-color: ${({ theme }) => theme.black100};
  }
`;
