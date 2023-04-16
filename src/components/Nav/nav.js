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
            <li className='home-page' aria-label="Go to Home page">
            <Link to="/">Home              
            </Link>
            </li>                  
            <li>
            <ol className='nav-links'>              
              <li><NavTitle><h2>Public</h2></NavTitle></li>
              <li>
                <Link to="/question">
                  <QuestionIcon/><span>Question</span></Link></li>
              <li><Link to="/tags">Tags</Link></li>
              <li><Link to="/users">Users</Link></li>              
              <li><Link to="/companies">Companies</Link></li>
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
  text-align: left;
  
  
  .nav-container{
    position: sticky;
    top: 50px;
    height: 100%;
    min-width: 164px;
    padding-top: 24px;
    margin-bottom: 8px;    
  }
  .left-sidebar {        
        
  }
  .home-page{
      padding-left: 100px;
      
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