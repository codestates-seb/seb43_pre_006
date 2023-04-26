import React from "react";
import styled from "styled-components";

export default function AskPageBottomArticle1() {
  return (
    <Container>
      <div className="title">Writing a good question</div>
      <div className="content">
        <p>
          You’re ready to <a href="#">ask</a> a{" "}
          <a href="#">programming-related question</a> and this form will help
          guide you through the process.
        </p>
        <p>
          Looking to ask a non-programming question? See{" "}
          <a href="#">the topics here</a> to find a relevant site.
        </p>
      </div>
      <span>Steps</span>
      <ul>
        <li>Summarize your problem in a one-line title.</li>
        <li>Describe your problem in more detail.</li>
        <li>Describe what you tried and what you expected to happen.</li>
        <li>
          Add “tags” which help surface your question to members of the
          community.
        </li>
        <li>Review your question and post it to the site.</li>
      </ul>
    </Container>
  );
}

const Container = styled.div`
  width: 70%;
  padding: 24px;
  box-sizing: border-box;
  background-color: ${({ theme }) => theme.powder100};
  border-radius: 3px;
  border: solid 1px ${({ theme }) => theme.blue200};
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
