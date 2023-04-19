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
import Main from "./components/Main/Main";
import QuestionItem from "./components/Main/Questions/Bottom/QuestionItem";
import { List } from "./components/Main/Questions/Bottom/ExampleList";
import AskPage from "./components/Main/Questions/AskPage";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <RecoilRoot>
        <Header />
        <Container>
          <Common />
          {/* 조건부로 현재 경로에 따라서 브라우저에 path name을 가져와서 */}

          <Routes>
            <Route path="/" element={<Main />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<SignUp />} />
            <Route
              path="/questions/:questionId"
              element={<QuestionItem data={List.data} />}
            />
            <Route path="/question/ask" element={<AskPage />} />
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
