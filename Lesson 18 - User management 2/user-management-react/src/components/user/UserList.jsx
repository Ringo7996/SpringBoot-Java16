import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function UserList() {
  const API_URL = "http://localhost:8080/users";
  const [filterUsers, setFilterUsers] = useState([]);
  const [searchValue, setSearchValue] = useState("");

  useEffect(() => {
    getUserList();
  }, []);

  async function getUserList() {

    let res = await axios.get(`${API_URL}`)

    // Sau khi có data thì hiển thị kết quả trên giao diện
    console.log(res.data.message);
  }



  const filterUser = () => {

  }

  const deleteUser = () => {

  }


  return (
    <>
      <div className="container mt-5 mb-5">
        <h2 className="text-center text-uppercase">User list</h2>

        <div className="row justify-content-center">
          <div className="col-md-10">
            <div className="d-flex justify-content-between align-items-center mt-5 mb-4">
              <Link to="/users/create" className="btn btn-warning">Create user</Link>
              <input
                type="text"
                id="search"
                className="form-control w-50"
                placeholder="Tìm kiếm user"
                onKeyDown={e => e.key === "Enter" ? filterUser() : null}
                onChange={e => setSearchValue(e.target.value)}
              />
            </div>

            <div className="bg-light p-4">
              <table className="table table-hover">
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th></th>
                  </tr>
                </thead>

                <tbody>
                  {filterUsers.map((user, index) => (
                    <tr key={user.id}>
                      <td>{index + 1}</td>
                      <td>{user.name}</td>
                      <td>{user.email}</td>
                      <td>{user.phone}</td>
                      <td>{user.address}</td>
                      <td>
                        <Link to={"/users/" + user.id} className="btn btn-success">Detail</Link>
                        <button className="btn btn-danger" onClick={() => deleteUser(user.id)}>Delete</button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>

              <p className="message d-none"></p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default UserList
