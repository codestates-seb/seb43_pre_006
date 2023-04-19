import React from "react";
import styled from "styled-components";
import AskPageTop from "./AskPageTop";
import AskPageBottom from "./AskPageBottom";

export default function AskPage() {
  return (
    <Background>
      <Container>
        <AskPageTop />
        <AskPageBottom />
      </Container>
    </Background>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  -webkit-box-pack: center;
  justify-content: center;
  margin-top: 50px;
  width: 100%;
  max-width: 1264px !important;
  flex: 1 0 auto;
`;

const Background = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  background: ${({ theme }) => theme.black050};
`;
