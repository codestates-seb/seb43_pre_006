import logo from "./logo.svg";
import "./App.css";
import { Routes, Route } from "react-router-dom";
import styled, { ThemeProvider } from "styled-components";
import { RecoilRoot } from "recoil";
import Header from "./components/Header/Header";
import theme from "./components/style/theme";
import Common from "./components/Header/Common";
import Login from "./components/Header/pages/Login";
import SignUp from "./components/Header/pages/SignUp/SignUp";
import Footer from "./components/Foot/Footer";
import Nav from "./components/NavBar/Nav";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <RecoilRoot>
        <Header />
        <Container>
          <Routes>
            <Route path="/" element={<Common />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<SignUp />} />
          </Routes>
        </Container>
        <Footer />
      </RecoilRoot>
    </ThemeProvider>
  );
}

export default App;

const Container = styled.div`
  display: flex;
  justify-content: center;
`;
