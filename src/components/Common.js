import styled from 'styled-components';

function Common() {
    const CommonPage = styled.div`
    width: 100%;
    height: 100vh;
    padding-top: 250px;
    display: flex;
    justify-content: center;
    font-size: 100px;
    `;

    return (
      <>        
        <CommonPage >공통페이지 입니다.</CommonPage>
      </>
    );
  }
  
  export default Common;