import React, { Component } from "react";
import { useSelector, useDispatch } from "react-redux";
import { connect } from "react-redux";
import { push } from "connected-react-router";
import { Router } from "./Router";
import "bootstrap/dist/css/bootstrap.min.css";
import NavBar from "./components/NavBar"
import Footer from "./components/Footer"

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
        <NavBar/>
        <Router props={this.props} />
        {/* <Footer /> */}
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  location: state.router.location,
});

export default connect(mapStateToProps)(App);
// export default App;
