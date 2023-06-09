import styled from "styled-components";

import NavTop from "./NavTop"

export default function Nav() {
  return (
    <Container>
      <NavTop />            
    </Container>
  );
}

const Container = styled.div`  
  position: relative;
  top: 0;
  display: flex;  
  height: 100%;
  max-width: 164px;
  min-width: 164px;
  flex-shrink: 0;
  box-sizing: inherit;
  text-align: left;
  
`;


