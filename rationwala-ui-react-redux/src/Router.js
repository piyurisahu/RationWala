import React,{Component} from "react";
import { Route, Redirect, Switch } from "react-router";
import Login from "./components/Login";
import Test from "./components/Test";

const Shopping = () => <p>Shopping</p>;
const announce = () => <p>Annouxxxxnce</p>;

export const Router = (props) => {
  return (
    <Switch>
      <React.Fragment>
        <Route exact path="/" render={(props) => <Test {...props} />} />
        <Route exact path="/login" render={(props) => <Login {...props} />} />
        <Route path="/shopping" component={Shopping} />
      </React.Fragment>
    </Switch>
  );
};
