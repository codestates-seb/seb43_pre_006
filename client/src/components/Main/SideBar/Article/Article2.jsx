import React from "react";
import styled from "styled-components";

export default function Article2() {
  return (
    <Container>
      <div className="title">Custom Filters</div>
      <div className="textBox">Create a custom filter</div>
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  margin-bottom: 16px;
  border: 1px solid ${({ theme }) => theme.black100};
  border-radius: 3px;
  box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
    0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);

  > .title {
    background-color: ${({ theme }) => theme.black025};
    color: ${({ theme }) => theme.black600};
    padding: 12px 16px;
  }

  > .textBox {
    padding: 12px 16px;
    background-color: ${({ theme }) => theme.white};
    color: ${({ theme }) => theme.blue500};
  }
`;
