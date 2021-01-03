import axios from "axios";
import { loginConstant } from "../_redux/actions/actionConstant";

// register(): POST {username, email, password}
// login(): POST {username, password} & save JWT to Local Storage
// logout(): remove JWT from Local Storage
const onSuccess = (response: any) => {
  return Promise.resolve(response);
};

const onError = (error: any) => {
  console.log(error);
  if (error.response) console.log("Server Side Error: " + error.response);
  else console.error("Request Error:", error.message);
  return Promise.reject(error.response || error.message);
};

const register = (username, email, password) => {
  return axios
    .request({
      method: "POST",
      url: "https://jsonplaceholder.typicode.com/users",
      // headers: {"Access-Control-Allow-Origin": "*"},
      data: {
        username: username,
        email: email,
        password: password,
      },
    })
    .then(onSuccess)
    .catch(onError);
};

const login = (username, password) => {
  return axios
    .request({
      method: "POST",
      url: "https://jsonplaceholder.typicode.com/users",
      // headers: {"Access-Control-Allow-Origin": "*"},
      data: {
        name: username,
      },
    })
    .then(onSuccess)
    .catch(onError);
};

const logout = () => {
  localStorage.removeItem("user");
};

export default {
  register,
  login,
  logout,
};
