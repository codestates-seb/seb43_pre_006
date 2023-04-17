import { atom } from "recoil";

export const filterState = atom({
  key: "filterState",
  default: false,
});

export const liClickEvent = atom({
  key: "liClickEvent",
  default:"li",
})