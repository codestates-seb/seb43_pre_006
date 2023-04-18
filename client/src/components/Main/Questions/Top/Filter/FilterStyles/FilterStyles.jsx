import styled from "styled-components";

export const FilterContainerStyle = styled.div`
  display: flex;
  flex-direction: column;
  width: calc(100% / 3);
  padding: 16px;

  > fieldset {
    padding: 0;
    border: none;
    > .title {
      font-weight: 600;
      margin: 4px 0;
    }

    > .checkBox {
      vertical-align: baseline;
      margin: 4px 0;

      > input {
        vertical-align: middle;
        border: solid 1px ${({ theme }) => theme.black100};
        border-radius: 3px;
      }

      > label {
        cursor: pointer;
        font-weight: 400;
        padding: 0 2px;
      }
    }
  }
`;
