import React from "react";
import styled from "styled-components";
import Article1 from "./Article/Article1";
import Article5 from "./Article/Article5";
import Article4 from "./Article/Article4";
import Article3 from "./Article/Article3";
import Article2 from "./Article/Article2";

export default function SideBar() {
  return (
    <Container>
      <Article1 />
      <Article2 />
      <Article3 />
      <Article4 />
      <Article5 />
    </Container>
  );
}

const Container = styled.div`
  width: 300px;
  margin-left: calc(24px * 1);
`;
