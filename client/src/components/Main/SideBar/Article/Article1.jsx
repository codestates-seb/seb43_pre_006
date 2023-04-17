import React from "react";
import styled from "styled-components";

export default function Article1() {
  return (
    <Container>
      <ul>
        <li className="title">The Overflow Blog</li>
        <ul className="textBox">
          <li>
            <svg
              aria-hidden="true"
              class="va-text-top svg-icon iconPencilSm"
              width="14"
              height="14"
              viewBox="0 0 14 14"
            >
              <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
            </svg>
            <span>Are meetings making you less productive?</span>
          </li>
          <li>
            <svg
              aria-hidden="true"
              class="va-text-top svg-icon iconPencilSm"
              width="14"
              height="14"
              viewBox="0 0 14 14"
            >
              <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
            </svg>
            The philosopher who believes in Web Assembly
          </li>
        </ul>
      </ul>

      <ul>
        <li className="title">Featured on Meta</li>
        <ul className="textBox">
          <li>
            <div
              class="favicon favicon-stackexchangemeta"
              title="Meta Stack Exchange"
            ></div>
            Improving the copy in the close modal and post notices - 2023
            edition
          </li>
          <li>Temporary policy: ChatGPT is banned</li>
          <li>The [protection] tag is being burninated</li>
          <li>
            Content Discovery initiative 4/13 update: Related questions using a
            Machine...
          </li>
        </ul>
      </ul>
      <ul>
        <li className="title">Hot Meta Posts</li>
        <ul className="textBox">
          <p>
            <span
              class="fc-black-500"
              title="Question score (upvotes - downvotes)"
            >
              6
            </span>
            Voting reversal for smaller tags with few answerers
          </p>
        </ul>
      </ul>
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  font-size: 12px;
  margin-bottom: 16px;
  background-color: ${({ theme }) => theme.yellow050};
  border-radius: 3px;
  border: 1px solid ${({ theme }) => theme.yellow400};
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;

  > ul {
    background-color: ${({ theme }) => theme.yellow100};
    border-color: ${({ theme }) => theme.yellow200};

    > .title {
      padding: 12px 15px;
      font-weight: bold;
      color: ${({ theme }) => theme.black600};
      border-bottom: #d4d4d4 solid 1px;
      border-top: #d4d4d4 solid 1px;
    }

    > .textBox {
      padding: 0px 16px;

      background-color: ${({ theme }) => theme.yellow050};

      > li {
        margin: 12px 0;

        > svg {
          margin-right: 5px;
        }
      }
    }
  }
`;
