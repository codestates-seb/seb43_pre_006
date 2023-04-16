import './App.css';
import Header from './components/Header';
import Login from './pages/Login';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Common from './components/Common';
import SignUp from './pages/SignUp/SignUp';
import Nav from './components/Nav/nav';
import Footer from './components/Footer/footer';


function App() {
  return (
    <Router>
      <>
        <Header />        
        <Nav/>
        <Footer/>
        <Routes>
          <Route path="/" element={<Common />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
        </Routes>        
      </>
    </Router>
  );
}

export default App;
