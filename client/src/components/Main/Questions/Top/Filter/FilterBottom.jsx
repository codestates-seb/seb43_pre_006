import React from "react";
import styled from "styled-components";
import { useRecoilState } from "recoil";
import { filterState } from "../../../../store/atom";

export default function FilterBottom() {
  const [filterBtn, setFilterBtn] = useRecoilState(filterState);

  return (
    <Container>
      <ApplyBtn>Apply Filter</ApplyBtn>
      <button className="cancle" onClick={() => setFilterBtn(!filterBtn)}>
        Cancle
      </button>
    </Container>
  );
}

const Container = styled.div`
  box-sizing: border-box;
  padding: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-top: solid 1px ${({ theme }) => theme.black100};

  > .cancle {
    border: none;
    background: none;
    color: ${({ theme }) => theme.blue600};
    cursor: pointer;
  }
`;

const ApplyBtn = styled.button`
  padding: 10px;
  background-color: ${({ theme }) => theme.blue500};
  color: white;
  border-radius: 0.2rem;
  display: block;
  font-size: 13px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  font-weight: 400;
  border: solid 1px transparent;
  cursor: pointer;
  &:hover {
    background-color: ${({ theme }) => theme.blue600};
  }
`;
