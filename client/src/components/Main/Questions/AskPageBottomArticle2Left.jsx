import React from "react";
import styled from "styled-components";

export default function AskPageBottomArticle2Left() {
  return (
    <Container>
      <div className="top">
        <label htmlFor="title" className="title">
          Title
        </label>
        <span>
          Be specific and imagine you’re asking a question to another person.
        </span>
      </div>
      <div className="bottom">
        <input
          type="text"
          id="title"
          placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
        />
      </div>
      <NextBtn>Next</NextBtn>
    </Container>
  );
}

const Container = styled.div`
  width: 70%;
  padding: 24px;
  background-color: white;
  border-radius: 3px;
  border: solid 1px ${({ theme }) => theme.black200};
  margin-bottom: 16px;
  margin-right: 20px;

  > .top {
    display: flex;
    flex-direction: column;
    margin-bottom: 8px;

    > .title {
      font-size: var(--_la-fs);
      color: var(--fc-dark);
      font-family: inherit;
      font-weight: 600;
      padding: 0 var(--su2);
      cursor: pointer;
    }

    > span {
      font-size: 12px;
      margin-top: var(--su2) !important;
      margin-bottom: var(--su2) !important;
    }
  }

  > .bottom {
    margin: calc(var(--su4) / 2);
    > input {
      width: 100%;
      background-color: var(--_in-bg);
      border: solid 1px ${({ theme }) => theme.black200};
      border-radius: 3px;
      color: var(--_in-fc);
      cursor: var(--_in-c);
      font-size: var(--_in-fs);
      padding: 0.5rem 0.6rem;
      box-sizing: border-box;

      &::placeholder {
        font-size: 13px;
        opacity: 0.5;
      }

      &:focus {
        box-shadow: 0px 0px 0 4px ${({ theme }) => theme.blue100};
      }
    }
  }
`;

const NextBtn = styled.button`
  display: inline-block;
  padding: 10px;
  background-color: ${({ theme }) => theme.blue500};
  color: white;
  border-radius: 0.2rem;
  font-size: 13px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  font-weight: 400;
  border: solid 1px transparent;
  cursor: pointer;
  margin-top: 8px;
  margin-bottom: 12px;
  &:hover {
    background-color: ${({ theme }) => theme.blue600};
  }
`;
