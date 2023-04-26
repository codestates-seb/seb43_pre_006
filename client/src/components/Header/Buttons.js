import styled from 'styled-components';

export const CommonButton = styled.button`
  background-color: #E1ECF4;
  margin: 4px;
  padding: 10px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border-radius: 3px;
  color: #39739D;
  font-size: 13px;
  border: 1px solid  'var(--blue-600)';
  opacity:  0.5;
  font-size: 13px;
  cursor : pointer;


  &:hover {
    background-color: #0A95FF;
    color: #fff;
  }
`;


export const LogButton = styled.button`
  background-color: #E1ECF4;
  margin: 4px;
  padding: 10px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border-radius: 3px;
  color: #39739D;
  font-size: 13px;
  border: 1px solid  'var(--blue-600)';
  opacity:  0.5;
  font-size: 13px;
  cursor : pointer;


  &:hover {
    background-color: #0A95FF;
    color: #fff;
  }
`;

export const SignButton = styled.button`
  background-color: #0A95FF;
  margin: 4px;
  padding: 10px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border-radius: 3px;
  color: #FFFFFF;
  font-size: 13px;
  border: 1px solid  'var(--blue-600)';
  opacity:  0.5;
  font-size: 13px;
  cursor : pointer;

  &:hover {
    background-color: #FFFFFF;
    color: #0A95FF;
  }

`;

export const GoogleButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color:  '#fff';
  padding: 10px;
  margin: 4px 0;
  border: 1px solid 'var(--black-100)';
  border-radius: 5px;
  font-size: 13px;
  color: 'var(--black-700)';
  outline: none;
  > svg {
    margin-right: 5px;
  }
`;
export const GitButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color:  '#fff';
  padding: 10px;
  margin: 4px 0;
  border: 1px solid 'var(--black-100)';
  border-radius: 5px;
  font-size: 13px;
  color: '#fff';
  outline: none;
  > svg {
    margin-right: 5px;
  }
`;
export const FacebookButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color:  '#385499';
  padding: 10px;
  margin: 4px 0;
  border: 1px solid 'var(--black-100)';
  border-radius: 5px;
  font-size: 13px;
  color: '#fff';
  outline: none;
  > svg {
    margin-right: 5px;
  }
`;