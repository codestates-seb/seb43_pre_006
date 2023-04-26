import styled from "styled-components";
import { ReactComponent as InfoIcon } from "../Header/images/infoIcon.svg";
import { ReactComponent as QuestionIcon } from "../Header/images/questionIcon.svg";
import { ReactComponent as CollectiveIcon } from "../Header/images/collectivesIcon.svg";
import { Link, useLocation } from "react-router-dom";


export default function NavTop() {
  //useLocation ===url  
  
  const NavList = {
    data: [
      {
        navId: 1,
        className: `public-li question-Icon question-li`,
        title: "Questions",
        icon: <QuestionIcon />,        
      },
      {
        navId: 2,
        className: "public-li",
        title: "Tags",
      },
      {
        navId: 3,
        className: "public-li",
        title: "Users",
      },
      {
        navId: 4,
        className: "public-li",
        title: "Companies",
      },
    ],
  };

  const navList = NavList.data;
  const location = useLocation();
  const path = location.pathname;

  console.log(path);  
  console.log(navList[0])
  
  return (
    <Container>
      <div className="nav-container">
        <div className="left-sidebar">
          <ol className="nav-links">
            <li className="home-page" aria-label="Go to Home page">
              Home
            </li>
            <li>
              <NavTitle>Public</NavTitle>
            </li>
            {navList.map((navItem) => (
              <li
                key={navItem.navId}
                className={
                  navItem.className
                }                             
              >
                <Link
                  to={`/`}
                >
                  {navItem.title === "Questions" ? (
                    <>
                      {navItem.icon}
                      {navItem.title}
                    </>
                  ) : (
                    navItem.title
                  )}
                </Link>
              </li>
            ))}
            <li className="collectives">
              <h2>Collectives</h2>
              <InfoIcon />
            </li>
            <li className="icon-li">
              <CollectiveIcon />
              Explore Collectives
            </li>
            <li className="teams-area">
              <NavTitle>Teams</NavTitle>
            </li>
          </ol>
        </div>
      </div>
    </Container>
  );
}

const Container = styled.div`
  position: sticky;
  border-right: 1px solid ${({ theme }) => theme.black100};
  width: auto;
  > .nav-container {
    height: 95%;
    top: 66px;
    min-width: 164px;
    > .left-sidebar {
      width: 100%;
      position: sticky;
      top: 80px;

      > ol {
        list-style: none;
        padding-left: 0;
        .public-li {
          padding: 8px;
          padding-left: 32.5px;
        }        
        .question-Icon {
          padding: 8px;
          padding-left: 8.5px;          
          a {
            display: flex;
            align-items: flex-end;
          }
          svg {
            margin-right: 5px;
          }
        }
        .teams-area {
          border-bottom: 1px solid ${({ theme }) => theme.black100};
        }
        .question-li {
          font-weight: bold;
          background: ${({ theme }) => theme.black050};
          color: ${({ theme }) => theme.black900};
          border-right: 3px solid ${({ theme }) => theme.orange400};
        }
        .collectives {
          display: flex;
          justify-content: space-between;
          align-items: center;
          margin: 10px 10px 0px 0px;
          background: var(--black-050);
          svg {
            fill: #6b737c;
          }
          > h2 {
            font-size: 11px;
            font-weight: 400;
            color: #6a737c;
            text-transform: uppercase;
          }
        }
        .icon-li {
          padding: 8px;
          align-items: center;
          display: flex;
          padding-left: 8.5px;
          > svg {
            margin-right: 5px;
          }
        }
        > li {
          font-size: 13px;
          padding-left: 8.5px;
          > a {
            text-decoration: none;
            color: var(--black-900);
          }
        }
      }
    }
  }
`;

const NavTitle = styled.h2`
  display: flex;
  padding: 16px 16px 4px 0px;
  font-size: 11px;
  font-weight: 400;
  color: #6a737c;
  text-transform: uppercase;
  svg {
    fill: #6b737c;
  }
`;
