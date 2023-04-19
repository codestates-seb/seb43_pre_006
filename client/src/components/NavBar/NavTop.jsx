import styled from 'styled-components';
import { ReactComponent as InfoIcon } from "../Header/images/infoIcon.svg";
import { ReactComponent as QuestionIcon } from "../Header/images/questionIcon.svg";
import { ReactComponent as CollectiveIcon } from "../Header/images/collectivesIcon.svg";
import { Link } from "react-router-dom";

export default function NavTop(){
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
              <li className='icon-li question-li'>
                  <QuestionIcon />
                <Link to="/">
                  Question
                </Link>
              </li>
              <li className='public-li'>
                <Link to="/tags">Tags</Link>
              </li>
              <li className='public-li'>
                <Link to="/">Users</Link>
              </li>
              <li className='public-li'>
                <Link to="/">Companies</Link>
              </li>
              <li className="collectives">              
                  <h2>Collectives</h2><InfoIcon />              
              </li>
              <li className='icon-li'>
                <CollectiveIcon/>Explore Collectives
              </li>
              <li className='teams-area'>
                <NavTitle>
                  <h2>Teams</h2>
                </NavTitle>
              </li>
            </ol>
          </div>          
        </div>                 
      </Container>
  )
}

const Container =styled.div`
  position: sticky;    
  border-right: 1px solid rgba(215, 217, 220, 255);
  width: auto;  
  >.nav-container {        
    height: 95%;
    top: 66px;
    min-width: 164px;     
    >.left-sidebar {
      width: 100%;
      position: sticky;
      top: 80px;   
      
      >ol {
        list-style: none;       
        padding-left: 0;
        .public-li{        
          padding: 8px;        
          padding-left: 32.5px;
        }
        .teams-area{
          border-bottom: 1px solid rgba(215, 217, 220, 255);
        }
        .question-li{
          font-weight: bold;
          background: hsl(210,8%,95%);
          color: hsl(210,8%,5%);
          border-right: 3px solid rgb(244, 130, 37);
        }
        .collectives{    
          display: flex;
          justify-content: space-between;
          align-items: center;
          margin: 10px 10px 0px 0px;
          background: var(--black-050); 
            svg {
              fill: #6b737c;
            }   
            >h2 {
            font-size: 11px;
            font-weight: 400;
            color: #6a737c;
            text-transform: uppercase;        
          }
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
        >li {          
          font-size: 13px;    
          padding-left: 8.5px;    
          >a {
            text-decoration: none;
            color: var(--black-900);;
          }  
        }
      }
    }
  }    
        
`;




const NavTitle = styled.div`
  display: flex;  
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