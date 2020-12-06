import React from "react";
import { push } from "connected-react-router";
import { Link, Route, Switch } from "react-router-dom";
import { history } from "../_redux/helpers/history";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { login } from "./../_redux/actions/index";
import { userLogin } from "../_redux/actions/actionConstant";

export const Test = (props) => {
  const dispatch = useDispatch();
  const user = useSelector((state) => state.auth);

  const goTo = (route) => {
    history.push(route.url);
  };

  const callApi = () => {
    dispatch(userLogin("1", "2")).then((res) => {
      
      console.log(user);
      debugger;
    });
    // axios
    //   .request({
    //     method: "POST",
    //     url: "https://jsonplaceholder.typicode.com/users",
    //     // headers: {"Access-Control-Allow-Origin": "*"},
    //     data: {
    //       name: "1",
    //     },
    //   })
    //   .then((res) => {
    //     debugger;
    //   });
  };
  return (
    <div>
      <ul>
        <li>
          <Link to="/">Announce</Link>
          {""}
        </li>
        <li>
          <Link to="/shopping">Shopping</Link>
        </li>
      </ul>

      <div>
        <button onClick={() => goTo({ url: "/shopping" })}>
          Click here to go to shopping
        </button>
        <button onClick={() => callApi()}>test APi call</button>
      </div>
    </div>
  );
};

export default Test;
