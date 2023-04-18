import { atom } from "recoil";

export const filterState = atom({
  key: "filterState",
  default: false,
});

export const loginState = atom({
  key: "loginState",
  default: false,
});