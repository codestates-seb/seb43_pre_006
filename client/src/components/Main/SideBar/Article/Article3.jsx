import React from "react";
import styled from "styled-components";

export default function Article3() {
  return (
    <Container>
      <div className="title">Watched Tags</div>
      <div className="textBox">
        <svg
          aria-hidden="true"
          class="fc-blue-400 d:fc-blue-700 svg-spot spotSearch"
          width="48"
          height="48"
          viewBox="0 0 48 48"
        >
          <path
            d="M29.22 38.1a3.4 3.4 0 0 1 4.81-4.82l8.81 8.81a3.4 3.4 0 0 1-4.81 4.81l-8.81-8.8Z"
            opacity=".2"
          ></path>
          <path d="M18.5 5a1 1 0 1 0 0 2c.63 0 1.24.05 1.84.15a1 1 0 0 0 .32-1.98A13.6 13.6 0 0 0 18.5 5Zm7.02 1.97a1 1 0 1 0-1.04 1.7 11.5 11.5 0 0 1 5.44 8.45 1 1 0 0 0 1.98-.24 13.5 13.5 0 0 0-6.38-9.91ZM18.5 0a18.5 18.5 0 1 0 10.76 33.55c.16.57.46 1.12.9 1.57L40 44.94A3.5 3.5 0 1 0 44.94 40l-9.82-9.82c-.45-.45-1-.75-1.57-.9A18.5 18.5 0 0 0 18.5 0ZM2 18.5a16.5 16.5 0 1 1 33 0 16.5 16.5 0 0 1-33 0Zm29.58 15.2a1.5 1.5 0 1 1 2.12-2.12l9.83 9.83a1.5 1.5 0 1 1-2.12 2.12l-9.83-9.83Z"></path>
        </svg>
        <p>Watch tags to curate your list of qusetions</p>
        <div className="btn">
          <svg
            aria-hidden="true"
            class="svg-icon iconEye"
            width="18"
            height="18"
            viewBox="0 0 18 18"
          >
            <path d="M9.06 3C4 3 1 9 1 9s3 6 8.06 6C14 15 17 9 17 9s-3-6-7.94-6ZM9 13a4 4 0 1 1 0-8 4 4 0 0 1 0 8Zm0-2a2 2 0 0 0 2-2 2 2 0 0 0-2-2 2 2 0 0 0-2 2 2 2 0 0 0 2 2Z"></path>
          </svg>
          Watch a tag
        </div>
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

    > svg {
      margin-right: 5px;
      color: ${({ theme }) => theme.blue400};
      vertical-align: bottom;

      > path {
        fill: currentColor;
      }
    }

    > p {
      color: ${({ theme }) => theme.black500};
      max-width: 160px;
      text-align: center;
    }

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
