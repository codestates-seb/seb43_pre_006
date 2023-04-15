import logo from "./logo.svg";
import "./App.css";
import { Routes, Route } from "react-router-dom";
import Main from "./Main/Main";
import styled, { ThemeProvider } from "styled-components";
import theme from "./style/theme";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Container>
        <Head></Head>
        <Bottom>
          <Main></Main>
        </Bottom>
      </Container>
    </ThemeProvider>
  );
}

export default App;

const Container = styled.div`
  display: flex;
  flex-direction: column;
`;

const Head = styled.div`
  width: 100%;
  height: 50px;
  background-color: #fbc6c6;
`;

const Bottom = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;
