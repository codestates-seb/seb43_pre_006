import { useRecoilState } from 'recoil';
import { CommonButton } from '../Buttons';
import { useNavigate } from 'react-router-dom';
import { loginState } from '../../store/atom';

const Logout = () => {
  const [isLoggedIn, setLoginState] = useRecoilState(loginState);

  const navigate = useNavigate();


  const handleLogout = () => {
    // Update the login state to indicate that the user is logged out
    setLoginState(false);

    // Redirect the user to the login page or home page
    navigate('/'); // or navigate('/');
  };

  return (
    <CommonButton
      bgColor="var(--blue-500)"
      color="#fff"
      border="transparent"
      onClick={handleLogout}
    >
      Logout
    </CommonButton>
  );
};

export default Logout;