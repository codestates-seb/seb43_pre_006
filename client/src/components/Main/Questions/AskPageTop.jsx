import React from "react";
import styled from "styled-components";

export default function AskPageTop() {
  return (
    <Container>
      <span>Ask a public question</span>
      <img
        src="https://cdn.sstatic.net/Img/ask/background.svg?v=2e9a8205b368"
        alt=""
      />
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  height: 130px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 27px;
  font-weight: 600;

  > img {
    height: 100%;
  }
`;
