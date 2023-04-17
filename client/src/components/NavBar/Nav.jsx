import styled from "styled-components";
import { ReactComponent as InfoIcon } from "../Header/images/infoIcon.svg";
import { ReactComponent as QuestionIcon } from "../Header/images/questionIcon.svg";
import { ReactComponent as CollectiveIcon } from "../Header/images/collectivesIcon.svg";
import { Link } from "react-router-dom";


export default function Nav() {
  
  
  return (
    <Container>
      <div className="nav-container">
        <div className="left-sidebar">
          <ol className="nav-links">
            <li className="home-page" aria-label="Go to Home page">
              Home
            </li>
            <li>
              <NavTitle>
                <h2>Public</h2>
              </NavTitle>
            </li>
            <li className='icon-li'>
                <QuestionIcon />
              <Link to="/">
                Question
              </Link>
            </li>
            <li className='public-li'>
              <Link to="/tags">Tags</Link>
            </li>
            <li className='public-li'>
              <Link to="/users">Users</Link>
            </li>
            <li className='public-li'>
              <Link to="/companies">Companies</Link>
            </li>
            <li className="collectives">              
                <h2>Collectives</h2><InfoIcon />              
            </li>
            <li className='icon-li'>
              <CollectiveIcon/>Explore Collectives
            </li>
            <li>
              <NavTitle>
                <h2>Teams</h2>
              </NavTitle>
            </li>
          </ol>
        </div>
      </div>
    </Container>
  );
}

const Container = styled.div`
  
  position: relative;
  top: 0;
  display: flex;  
  height: 100%;
  max-width: 164px;
  

  .nav-container {
    position: sticky;    
    height: 100%;
    top: 66px;
    min-width: 164px;    
    border-right: 1px solid rgba(215, 217, 220, 255);
  }
  .left-sidebar {
    width: 100%;
    position: sticky;
    top: 80px;   
    border-bottom: 1px solid rgba(215, 217, 220, 255);
  }
  .public-li{        
    height: 17px;
    padding: 8px;        
    padding-left: 32.5px;
  }
  .icon-li{    
    padding: 8px;
    align-items: center;
    display: flex;
    padding-left: 8.5px;
    >svg{
      margin-right:5px ;      
    }
  }
  .collectives{    
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 10px 10px 0px 0px;
    background: var(--black-050);    
    >h2 {
    font-size: 11px;
    font-weight: 400;
    color: #6a737c;
    text-transform: uppercase;
  }
  svg {
    fill: #6b737c;
  }
  }  

  ol {
    list-style: none;       
    padding-left: 0;
    a {
      text-decoration: none;
      color: #525960;
    }
  }
  li {
    text-align: -webkit-match-parent;
    font-size: 13px;    
    padding-left: 8.5px;
    
    
  }
  /* .clicked {
      background: var(--black-050);
      font-weight: bold;
      color: var(--black-900);
      border-right: 3px solid rgb(244, 130, 37);
    } */
`;

const NavTitle = styled.div`
  display: flex;
  /* justify-content: space-between;
  align-items: center; */
  padding: 16px 16px 4px 0px;

  h2 {
    font-size: 11px;
    font-weight: 400;
    color: #6a737c;
    text-transform: uppercase;
  }

  svg {
    fill: #6b737c;
  }
  
`;
