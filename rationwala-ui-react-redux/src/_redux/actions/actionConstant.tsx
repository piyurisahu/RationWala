import AuthService from "../../services/auth.services";
export const loginConstant = {
  LOGIN_REQUEST: "USERS_LOGIN_REQUEST",
  LOGIN_SUCCESS: "USERS_LOGIN_SUCCESS",
  LOGIN_FAILURE: "USERS_LOGIN_FAILURE",
  LOGOUT: "USERS_LOGOUT",
};

export const userLogin = (username, password) => (dispatch) => {
  return AuthService.login(username, password).then((response) => {
    dispatch({ type: loginConstant.LOGIN_SUCCESS, payload: response.data });
  });
};
