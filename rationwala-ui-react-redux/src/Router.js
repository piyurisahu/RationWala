import React,{Component} from "react";
import { Route, Redirect, Switch } from "react-router";
import Login from "./components/Login";
import Profile from "./components/Profile";
import Register from "./components/Register";

import Test from "./components/Test";

const Shopping = () => <p>Shopping</p>;
const announce = () => <p>Annouxxxxnce</p>;

export const Router = (props) => {
  return (
    <Switch>
      <React.Fragment>
        <Route exact path="/" render={(props) => <Test {...props} />} />
        <Route exact path="/login" render={(props) => <Login {...props} />} />
        <Route exact path="/profile" render={(props) => <Profile {...props} />} />
        <Route exact path="/register" render ={(props) => <Register {...props} />}/>

        <Route path="/shopping" component={Shopping} />

      </React.Fragment>
    </Switch>
  );
};
