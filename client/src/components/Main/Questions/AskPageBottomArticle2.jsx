import React from "react";
import styled from "styled-components";

export default function AskPageBottomArticle2() {
  return <Container>1</Container>;
}

const Container = styled.div`
  width: 70%;
  padding: 24px;
  box-sizing: border-box;
  background-color: white;
  border-radius: 3px;
  border: solid 1px ${({ theme }) => theme.black100};
  margin-bottom: 16px;

  > .title {
    font-size: 21px;
    font-weight: 400;
    margin-bottom: 8px;
  }

  > .content {
    > p {
      margin: 0;
      font-size: 15px;
      > a {
        text-decoration: none;
        color: ${({ theme }) => theme.blue600};
      }
    }

    & p:nth-of-type(2) {
      margin-bottom: 15px;
    }
  }

  > span {
    display: inline-block;
    font-weight: 600;
    font-size: 13px;
    margin-bottom: 8px;
  }

  > ul {
    margin-left: 30px;
    font-size: 13px;

    > li {
      font-size: 13px;
      list-style-type: disc !important;
    }
  }
`;
