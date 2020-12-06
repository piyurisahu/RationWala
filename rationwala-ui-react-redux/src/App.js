import React, { Component } from "react";
import { useSelector, useDispatch } from "react-redux";
import { Link, Route, Switch } from "react-router-dom";
import { increment } from "./_redux/actions";
import { connect } from "react-redux";
import { push } from "connected-react-router";
import { Router } from "./Router";

// const countera = useSelector((state) => state.counter);
// const isLogged = useSelector((state) => state.isLogged);
// const dispatch = useDispatch();
class App extends Component {
  // goTo = (route) => {
  //   this.props.dispatch(push(route.url));
  // };

  // <button onClick={() => this.goTo({ url: "/shopping" })}>
  //   Click here to go to shopping
  // </button>
  /* <div>{countera}</div>
      <button onClick={() => dispatch(increment())}>+</button> */
  render() {
    return (
      <div>
        <h1>Hello</h1>

        <Router props={this.props} />
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  location: state.router.location,
});

export default connect(mapStateToProps)(App);
// export default App;
