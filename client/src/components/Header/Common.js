import styled from "styled-components";
import Main from "./../Main/Main";
import Nav from "./../NavBar/Nav";

function Common() {
  const CommonPage = styled.div`
    width: 100%;
    padding-top: 50px;
    display: flex;
    justify-content: center;    
  `;

  return (
    <>
      <CommonPage>
        <Nav></Nav>
        <Main />
      </CommonPage>
    </>
  );
}

export default Common;
