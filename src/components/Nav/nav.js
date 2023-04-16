import styled from "styled-components";
import { ReactComponent as InfoIcon } from '../../assets/images/infoIcon.svg';
import { ReactComponent as QuestionIcon } from '../../assets/images/questionIcon.svg';
import{Link} from 'react-router-dom'

export default function Nav(){


  return (
    <Container>
      <div className='nav-container'>
        <div className='left-sidebar'>          
            <ol className='nav-links'>
            <li aria-label="Go to Home page">
            <Link to="/">Home              
            </Link>
            </li>                  
            <li>
            <ol className='nav-links'>              
              <li><NavTitle><h2>Public</h2></NavTitle></li>
              <li>
                <Link to="/nav-question">
                  <QuestionIcon/><span>Question</span></Link></li>
              <li>Tags</li>
              <li>Users</li>              
              <li>Companies</li>
              <li><NavTitle><h2>Collectives</h2></NavTitle><InfoIcon/></li>
              <li><NavTitle><h2>Teams</h2></NavTitle></li>                                   
            </ol>
            </li>
            </ol>          
        </div>
      </div>
    </Container>
  );
}


const Container = styled.div`
  display: flex;
  height: 100%;    
  
  
  .nav-container{
    position: sticky;
    top: 50px;
    height: 100%;
    min-width: 164px;
    padding-top: 24px;
    margin-bottom: 8px;
  }
  .left-sidebar {        
    position: sticky;
    width: auto;    
    margin-bottom: var(--su8);    
    overflow-y: auto;    
    top: var(--top-bar-allocated-space);
    max-height: calc(100vh - var(--top-bar-allocated-space));
    padding-top: var(--su24);
    
  }
  ol{    
    list-style: none;    
    display: block;    
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
  }
  li {
    text-align: -webkit-match-parent;
    padding: 4px 4px 4px 30px;
  }

`
const NavTitle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 16px 8px 4px 8px;

  h2 {
    font-size: 11px;
    font-weight: 400;
    color: #6a737c;
    text-transform: uppercase;
  }

  svg {
    fill: #6b737c;
  }
`