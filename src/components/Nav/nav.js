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
              <li><NavTitle><h2>Public</h2></NavTitle></li>
              <li>
                <Link to="/question">
                  <QuestionIcon/>Question</Link></li>
              <li><Link to="/tags">Tags</Link></li>
              <li><Link to="/users">Users</Link></li>              
              <li><Link to="/companies">Companies</Link></li>
              <li className='collectives'><NavTitle><h2>Collectives</h2><InfoIcon/></NavTitle></li>
              <li><NavTitle><h2>Teams</h2></NavTitle></li>                                               
            </ol>          
        </div>
      </div>
    </Container>
  );
}


const Container = styled.div`
  display: flex;
  height: 100%;      
  width: 100%;
  max-width: 164px;  
  
  
  
  .nav-container{    
    margin-top: 50px;
    height: 100%;
    min-width: 164px;
    padding-top: 24px;      
    border-right:1px solid rgba(215,217,220,255);
  }
  .left-sidebar {        
    width: 100%;
  }
  
  
  ol{            
    list-style: none;        
    padding-left: 8.5px;    
    a{
    text-decoration:none;
    color: #525960;
  }
  }
  li {    
    text-align: -webkit-match-parent;
  }
  
  `

const NavTitle = styled.div`
  display: flex;
  /* justify-content: space-between;
  align-items: center; */  
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