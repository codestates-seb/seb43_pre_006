import React from "react";
import { Routes, Route } from "react-router-dom";
import styled from "styled-components";
import SideBar from "./SideBar/SideBar";

export default function Main() {
  return (
    <Container>
      <SideBar></SideBar>
    </Container>
  );
}

const Container = styled.div`
  width: calc(100% - 164px);
  max-width: 1100px;
  padding: calc(24px * 1);
`;
