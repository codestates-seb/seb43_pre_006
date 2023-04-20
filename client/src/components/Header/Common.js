import styled from "styled-components";
import Nav from "./../NavBar/Nav";

function Common() {
  const CommonPage = styled.div`
    padding-top: 50px;
    display: flex;
    justify-content: center;    
  `;


  return (
    <>
      <CommonPage>        
        <Nav/>
      </CommonPage>
    </>
  );
}

export default Common;
