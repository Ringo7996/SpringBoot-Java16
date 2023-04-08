
import React, { useEffect, useState } from "react";
import UserInfo from "./UserInfo";
import LoginForm from "./LoginForm";

function LoginApp() {
    const API_URL = "http://localhost:8080/login";
    // const [username, setUsername] = useState();
    // const [password, setPassword] = useState();
    const [user, setUser] = useState([]);


    const getInputIdPW = (inputUsername, inputPW) => {
        // setUsername(inputUsername);
        // setPassword(inputPW);


        handleLogin(inputUsername, inputPW)
    }


    const handleLogin = async (inputUsername, inputPW) => {
        try {
            let result = await fetch(API_URL + `?username=${inputUsername}&password=${inputPW}`, {
                method: "GET",
            });


            if (result.status === 200) {
                let Loginuser = await (result).json();
                setUser(Loginuser)

                if (!Loginuser.id){
                    alert("username hoặc password không chính xác")
                }
            } else {
                console.error(result);
            }
        } catch (error) {
            console.error(error);
        }
    }

    if (user.id) {
        return ( <UserInfo user={user} />)
    } else {
        return (
            <>
                <LoginForm getInputIdPW={getInputIdPW} />
                <UserInfo user={user} />
            </>
        );
    }
}

export default LoginApp;
