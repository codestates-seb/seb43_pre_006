import React from "react";
import styled from "styled-components";
import FilterBy from "./FilterBy";
import SortedBy from "./SortedBy";
import TaggedWith from "./TaggedWith";
import FilterBottom from "./FilterBottom";

export default function FilterContainer() {
  return (
    <Container>
      <Top>
        <FilterBy />
        <SortedBy />
        <TaggedWith />
      </Top>
      <FilterBottom />
    </Container>
  );
}

const Container = styled.div`
  background-color: ${({ theme }) => theme.black050};
  display: flex;
  flex-direction: column;
  border: solid 1px ${({ theme }) => theme.black100};
  border-radius: 3px;
  margin-bottom: 16px;
`;

const Top = styled.div`
  display: flex;
`;
