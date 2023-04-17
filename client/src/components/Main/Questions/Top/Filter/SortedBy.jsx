import React from "react";
import styled from "styled-components";
import { FilterContainerStyle } from "./FilterStyles/FilterStyles";

export default function SortedBy() {
  const checkBox = [
    "Newest",
    "Recent activity",
    "Highest score",
    "Most frequent",
    "Bounty ending soon",
  ];

  return (
    <FilterContainerStyle>
      <fieldset>
        <legend className="title">Sorted by</legend>
        {checkBox.map((el, idx) => (
          <div className="checkBox" key={idx}>
            <input type="radio" id={`${idx}_sorted`} name="sort" />
            <label for={`${idx}_sorted`}>{el}</label>
          </div>
        ))}
      </fieldset>
    </FilterContainerStyle>
  );
}
