import React from "react";
import styled from "styled-components";

export default function AddAsk() {
  return <Container>Ask Question</Container>;
}

const Container = styled.div`
  padding: 0.8rem;
  background-color: ${({ theme }) => theme.blue500};
  color: white;
  border-radius: 0.2rem;
  display: block;
  font-size: 13px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  font-weight: bold;
  border: solid 1px transparent;
  cursor: pointer;
`;
