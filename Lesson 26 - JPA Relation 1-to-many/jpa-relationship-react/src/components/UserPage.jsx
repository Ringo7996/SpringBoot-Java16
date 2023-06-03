import { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";

let userList = [];
const API_URL = "http://localhost:8080/api/v1/users"
function UserPage() {
    const [users, setUser] = useState([])


    useEffect(() => {
        getUserList()
    }, [])


    const getUserList = async () => {
        let res = await axios.get(`${API_URL}`)
        userList = res.data;
        setUser(userList);
    }


    return (
        <>
            <div className="container">
                <h2 className="mt-5 mb-3">Danh sách user</h2>

                <div className="row">
                    <div className="col-4">
                        <table className="table table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {userList.map((user) => (
                                    <tr key={user.id} >
                                        <td>{user.id}</td>
                                        <td>{user.name}</td>
                                        <td> <Link to={`${user.id}/files`}>Detail</Link></td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    )
}

export default UserPage
