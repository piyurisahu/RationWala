import { loginConstant } from "../actions/actionConstant";
const intialState = {
  user: null,
  error: null,
};
const authReducer = (state = intialState, action) => {
  debugger;
  switch (action.type) {
    case loginConstant.LOGIN_SUCCESS:
      return { ...state, user: action.payload };
    default:
      return state;
  }
};

export default authReducer;
