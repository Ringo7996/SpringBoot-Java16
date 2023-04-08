
import React, { useEffect, useState } from "react";
import UserInfo from "./UserInfo";

function LoginForm(props) {
    const API_URL = "http://localhost:8080/login";
    const [inputUsername, setinputUsername] = useState();
    const [inputPassword, setinputPassword] = useState();

    const sendInput = () => {
        props.getInputIdPW(inputUsername, inputPassword)

    }

    return (
        <div className="login-form">
            <input id="username" onChange={e => setinputUsername(e.target.value)}></input>
            <input id="password" onChange={e => setinputPassword(e.target.value)}></input>
            <button onClick={sendInput}>Login</button>
        </div>
    );
}

export default LoginForm;
