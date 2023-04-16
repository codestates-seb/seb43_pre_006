import styled from 'styled-components';
import { ReactComponent as SearchIcon } from '../assets/images/searchIcon.svg';


const SearchContainer = styled.form`
  position: relative;
  flex-grow: 1;
  #search-icon {
    position: absolute;
    left: 0.5em;
    top: 50%;
    margin-top: -9px;
  }
`;

const SearchBar = styled.input`
  display: block;
  width: 92%;
  background-color: #fff;
  border: 1px solid black;
  font-size: 13px;
  color: var(--black-700);
  border-radius: 3px;
  padding: 0.6em 0.7em;
  padding-left: 32px;
  outline: none;
  &:focus {
    box-shadow: 0px 0px 0px 4px var(--powder-200);
    border-color: var(--blue-600);
  }
`;

const Search = () => {

  return (
    <SearchContainer >
      <SearchIcon
        id="search-icon"
        width="18px"
        height="18px"
        fill="hsl(210,8%,55%)"
      />
      <SearchBar
        placeholder="Search..."
      />
    </SearchContainer>
  );
};

export default Search;