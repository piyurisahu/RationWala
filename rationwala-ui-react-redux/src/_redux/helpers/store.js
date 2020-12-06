import { applyMiddleware, createStore } from "redux";
import rootReducer from "../reducers";
import thunkMiddleware from "redux-thunk";
import { routerMiddleware } from "connected-react-router";
import { createLogger } from "redux-logger";
import { isCompositeComponentWithType } from "react-dom/test-utils";
import { composeWithDevTools } from "redux-devtools-extension";

import { history } from "./history";

const loggerMiddleware = createLogger();
const routerMiddleWare = routerMiddleware(history);

const middlewares = [thunkMiddleware, routerMiddleWare, loggerMiddleware]

const appliedMiddlewares = composeWithDevTools(applyMiddleware(...middlewares));
export const store = createStore(
    rootReducer(history),
    // window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
    appliedMiddlewares
  );