import React from "react";
import styled from "styled-components";
import AddAsk from "./AddAsk";
import { Link } from "react-router-dom";

export default function QuestionsTop() {
  return (
    <Container>
      <span>All Questions</span>
      <Link to={"/question/ask"}>
        <AddAsk />
      </Link>
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 12px;

  > span {
    display: inline-block;
    font-size: 27px !important;
    font-weight: normal;
    line-height: 1.3rem;
    margin-bottom: 12px;
  }

  > a {
    text-decoration: none;
  }
`;
