import { loginConstant } from "./actionConstant";

export const increment = () => {
  return { type: "INCREMENT" };
};

export const decrement = () => {
  return { type: "DECREMENT" };
};

export const login = () => {
  return { type: "LOGIN" };
};

export const loginSuccess = (data) => {
  return {
    type: loginConstant.LOGIN_SUCCESS,
    payload: data,
  };
};
