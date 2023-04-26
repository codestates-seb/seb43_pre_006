import React from "react";
import { FilterContainerStyle } from "./FilterStyles/FilterStyles";

export default function TaggedWith() {
  const checkBox = ["My watched tags", "The following tags:"];

  return (
    <FilterContainerStyle>
      <fieldset>
        <legend className="title">Tagged with</legend>
        {checkBox.map((el, idx) => (
          <div className="checkBox">
            <input type="radio" id={`${idx}tagged`} name="tag" />
            <label for={`${idx}tagged`}>{el}</label>
          </div>
        ))}
        <input type="text" />
      </fieldset>
    </FilterContainerStyle>
  );
}
