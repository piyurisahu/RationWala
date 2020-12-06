import axios from "axios";

// register(): POST {username, email, password}
// login(): POST {username, password} & save JWT to Local Storage
// logout(): remove JWT from Local Storage
const onSuccess = (response: any) => {
  debugger;
  return Promise.resolve(response);
};

const onError = (error: any) => {
  console.log(error);
  debugger;
  if (error.response) console.log("Server Side Error: " + error.response);
  else console.error("Request Error:", error.message);
  return Promise.reject(error.response || error.message);
};

const register = (username, email, password) => {};

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

const logout = () => {};

export default {
  register,
  login,
  logout,
};
