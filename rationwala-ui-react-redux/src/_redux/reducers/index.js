import counterReducer from "./counter";
import authReducer from "./AuthReducer";
import loggedReducer from "./isLogged";
import { combineReducers } from "redux";
import { connectRouter } from "connected-react-router";

const rootReducer = (history) =>
  combineReducers({
    counter: counterReducer,
    auth: authReducer,
    isLogged: loggedReducer,
    router: connectRouter(history),
  });

export default rootReducer;
