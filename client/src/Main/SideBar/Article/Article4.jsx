import React from "react";
import styled from "styled-components";

export default function Article4() {
  return (
    <Container>
      <div className="title">Igonored Tags</div>
      <div className="textBox">
        <div className="btn">Add an ignored tag</div>
      </div>
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
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 16px 15px;
    background-color: ${({ theme }) => theme.white};
    color: ${({ theme }) => theme.blue700};
    font-size: 12px;

    > .btn {
      border: ${({ theme }) => theme.powder500} solid 1px;
      background-color: ${({ theme }) => theme.powder100};
      margin: 8px 0;
      padding: 9px;
      border-radius: 3px;

      > svg {
        margin-right: 5px;
        color: ${({ theme }) => theme.powder700};
        vertical-align: bottom;

        > path {
          fill: currentColor;
        }
      }
    }
  }
`;
