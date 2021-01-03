import { loginConstant } from "../actions/actionConstant";

const intialState = {};

const authReducer = (state = intialState, action) => {
  const user = JSON.parse(localStorage.getItem("user"));

  state = user
    ? { isLoggedIn: true, user: user }
    : { isLoggedIn: false, user: null };
  switch (action.type) {
    case loginConstant.LOGIN_SUCCESS:
      return { ...state, user: action.payload, isLoggedIn: true };

    case loginConstant.LOGOUT:
      return {
        ...state,
        isLoggedIn: false,
        user: null,
      };

    case loginConstant.REGISTER:
      return {
        ...state,
        isLoggedIn: false,
      };
    default:
      return state;
  }
};

export default authReducer;
