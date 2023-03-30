import React, { useEffect, useState } from "react";
let data = [
    {
        id: 1,
        name: "Bùi Hiên",
        email: "hien@gmail.com",
        address: "Thái Bình",
    },
    {
        id: 2,
        name: "Thu Hằng",
        email: "hang@gmail.com",
        address: "Hải Dương",
    },
    {
        id: 3,
        name: "Minh Duy",
        email: "duy@gmail.com",
        address: "Hưng Yên",
    },
];


let Firstrandom = data[Math.floor(Math.random() * data.length)]
function RandomUser() {
    const [user, setUser] = useState(Firstrandom);
    const [name, setName] = useState(Firstrandom.name);
    const [email, setEmail] = useState(Firstrandom.email);
    const [address, setAdress] = useState(Firstrandom.address);  

    function randomUser() {
        let randomUser = data[Math.floor(Math.random() * data.length)]
        while (randomUser.id == user.id) {
            randomUser = data[Math.floor(Math.random() * data.length)]
        }
        setUser(randomUser);
        setName(randomUser.name);
        setEmail(randomUser.email);
        setAdress(randomUser.address);
    }

    const [rdBtndisplay, setrdBtndisplay] = useState();
    const [dlBtndisplay, setdlBtndisplay] = useState();
    function deleteUser() {
        for (let i = 0; i < data.length; i++) {
            if (user.id == data[i].id) {
                data.splice(i, 1);
                break;
            }
        }
        if (data.length == 1) {
            setrdBtndisplay("none")
            randomUser();
        } else if (data.length == 0) {
            setdlBtndisplay("none")
        } else {
            randomUser();
        }
    }

    if (data.length != 0) {
        return (
            <div>
                <h1 style={{ color: "red" }}>Name: {name} </h1>
                <ul>
                    <li>Email: {email} </li>
                    <li>Address: {address} </li>
                </ul>
                <button id="ramdom-btn" style={{ display: rdBtndisplay }} onClick={randomUser}>Random User</button>
                <button id="delete-btn" style={{ display: dlBtndisplay }} onClick={deleteUser}>Delete User</button>
            </div>
        );
    } else {
        return (
            <p>Không còn user nào trong danh sách </p>
        )
    }
}

export default RandomUser;

