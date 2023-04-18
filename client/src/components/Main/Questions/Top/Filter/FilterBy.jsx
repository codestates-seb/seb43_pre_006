import React from "react";
import styled from "styled-components";
import { FilterContainerStyle } from "./FilterStyles/FilterStyles";

export default function FilterBy() {
  const checkBox = ["No answers", "No accepted answer", "Has bounty"];

  return (
    <FilterContainerStyle>
      <fieldset>
        <legend className="title">Filter by</legend>
        {checkBox.map((el, idx) => (
          <div className="checkBox" key={idx}>
            <input type="checkbox" id={`${idx}_filter`} />
            <label for={`${idx}_filter`}>{el}</label>
          </div>
        ))}
      </fieldset>
    </FilterContainerStyle>
  );
}
