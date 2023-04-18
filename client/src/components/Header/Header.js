import styled from "styled-components";
import sprites from "./images/sprites.svg";
import Search from "./Search";
import { LogButton, SignButton } from "./Buttons";
import { Link, useNavigate } from "react-router-dom";
import { useRecoilState } from "recoil";
import { loginState } from "../store/atom";


const HeaderContainer = styled.header`
  width: 100%;
  position: fixed;
  z-index: 10;
  height: 50px;
  border-top: 3px solid var(--orange-400);
  background-color: var(--black-025);
  display: flex;
  justify-content: center;
  align-items: center;
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
  background-color: ${({ theme }) => theme.black025};

  .header-container {
    width: 1264px;
    max-width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: white;
  }

  .logo {
    height: 100%;
    margin: 0;
    padding: 0 8px;
    display: flex;
    align-items: center;
  }

  .logo-img {
    display: block;
    width: 150px;
    height: 30px;
    margin-top: -4px;
    background: url(${sprites}) 0 -500px no-repeat;
  }

  .gnb {
    display: flex;
    align-items: center;
    padding: 2px 0;
    margin: -2px;
    color: var(--black-600);
    font-size: 13px;
  }

  .gnb ul {
    padding: 6px 12px;
    margin: 2px;
  }

  .button-container {
    display: flex;
  }

  .button-container button {
    padding: 8px 10px;
  }
`;

const Header = () => {
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate("/login");
  };

  const handleSignup = () => {
    navigate("/signup");
  };

  const [loginCheck, setLoginCheck] = useRecoilState(loginState);


  return (
    /* 헤더 콘테이너 */
    <HeaderContainer>
      <div className="header-container">
        <h1 className="logo">
          <Link to="/">
            <span className="logo-img hide"></span>
          </Link>
        </h1>
        <ul className="gnb">
          <ul>About</ul>
          <ul>Products</ul>
          <ul>For Teams</ul>
        </ul>
        <Search />
        <div className="but<ton-container">
          {loginCheck ?( <h1>로그인 되어있습니다</h1>):
          (
            <>
           <LogButton onClick={handleLogin}>Log in</LogButton>
          <SignButton
            bgColor="var(--blue-500)"
            color="#fff"
            border="transparent"
            onClick={handleSignup}
          >
            Sign up
          </SignButton>
          </>)}
        </div>
      </div>
    </HeaderContainer>
  );
};

export default Header;
