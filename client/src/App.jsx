import "./App.css";
import { Routes, Route, useLocation } from "react-router-dom";
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
  const location = useLocation();
  const hide = ["/login", "/signup", "/question/ask"];
  // 주소값에 따라 Common 컴포넌트 렌더링 막기

  const hideCommon = hide.includes(location.pathname);

  return (
    <ThemeProvider theme={theme}>
      <RecoilRoot>
        <Header />
        <Container>
          {!hideCommon && <Common />}
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
