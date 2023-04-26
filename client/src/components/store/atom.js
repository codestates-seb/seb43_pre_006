import { atom } from "recoil";

export const filterState = atom({
  key: "filterState",
  default: false,
});

export const loginState = atom({
  key: "loginState",
  default: false,
});

export const titleText = atom({
  key: "titleText",
  default: "",
});

export const textEditorState = atom({
  key: "textEditorState",
  default: false,
});
