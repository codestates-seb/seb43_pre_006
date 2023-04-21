import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

export default function ItemLeft({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));

  const UpBtn = styled.svg`
    fill: ${({ theme }) => theme.black100};
    width: 36px;
    height: 36px;
  `;

  const DownBtn = styled.svg`
    fill: ${({ theme }) => theme.black100};
    width: 36px;
    height: 36px;
  `;

  const BookMark = styled.svg`
    fill: ${({ theme }) => theme.black100};
    width: 18px;
    height: 18px;
  `;

  const Timer = styled.svg`
    fill: ${({ theme }) => theme.black100};
    width: 18px;
    height: 18px;
    margin-left: -2px;
  `;

  return (
    <Container>
      <UpBtn viewBox="0 0 36 36">
        <path d="M2 25h32L18 9 2 25Z"></path>
      </UpBtn>
      <span>{question.score}</span>
      <DownBtn viewBox="0 0 36 36">
        <path d="M2 11h32L18 27 2 11Z"></path>
      </DownBtn>
      <BookMark viewBox="0 0 18 18">
        <path d="m9 10.6 4 2.66V3H5v10.26l4-2.66ZM3 17V3c0-1.1.9-2 2-2h8a2 2 0 0 1 2 2v14l-6-4-6 4Z"></path>
      </BookMark>
      <Timer viewBox="0 0 18 18">
        <path d="M3 9a8 8 0 1 1 3.73 6.77L8.2 14.3A6 6 0 1 0 5 9l3.01-.01-4 4-4-4h3L3 9Zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5Z"></path>
      </Timer>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-right: 16px;

  > span {
    font-size: 21px;
  }

  > svg {
    cursor: pointer;
    padding: 6px 0;
  }
`;
