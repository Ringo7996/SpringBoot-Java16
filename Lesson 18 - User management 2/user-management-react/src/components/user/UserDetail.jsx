import React, { useState, useEffect } from 'react'
import { useParams, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import axios from 'axios';

const API_URL = "http://localhost:8080/users";
function UserDetail() {
    const { userId } = useParams();
    const [user, setUser] = useState([]);
    const [addressList, setAddressList] = useState([]);
    const { register, reset, handleSubmit, formState: { errors } } = useForm();
    const navigate = useNavigate();

    useEffect(() => {
        getUserById();
        getProvinces();
    }, [reset]);

    async function getUserById() {
        let res = await axios.get(`${API_URL}/${userId}`)

        if (res.status === 200) {
            let userById = res.data;
            setUser(userById);
        } else {
            console.error(res);
        }
        reset(res.data);
    }


    async function getProvinces() {
        let res = await axios.get("https://provinces.open-api.vn/api/p/")

        if (res.status === 200) {
            let provinces = res.data;
            setAddressList(provinces);
        } else {
            console.error(res);
        }
    }

    const onSubmit = async data => {
        console.log(data)
        try {
            let res = await axios.put(`${API_URL}/${userId}`, data);

            if (res.status === 200) {
                alert(`Thay đổi thông tin người dùng thành công`);
            } else {
                console.log(res.message)
            }
        } catch (error) {
            alert(error.response.data.message);
        }

    }

    return (
        <>
            <div className="container mt-5 mb-5">
                <h2 className="text-center text-uppercase mb-3">Thông tin user</h2>

                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <form onSubmit={handleSubmit(onSubmit)}>
                            <div className="bg-light p-4">
                                <div className="mb-3">
                                    <label className="col-form-label">Fullname</label>
                                    <input type="text" id="fullname" className="form-control" defaultValue={user.name} {...register("name")} />
                                </div>
                                <div className="mb-3">
                                    <label className="col-form-label">Email</label>
                                    <input type="text" id="email" className="form-control" disabled defaultValue={user.email} {...register("email")} />
                                </div>
                                <div className="mb-3">
                                    <label className="col-form-label">Phone</label>
                                    <input type="text" id="phone" className="form-control" defaultValue={user.phone}  {...register("phone")} />
                                </div>
                                <div className="mb-3">
                                    <label className="col-form-label"  >Address</label>
                                    <select className="form-select" id="address" {...register("address")} >
                                        <option defaultValue={user.address} >
                                            {user.address}
                                        </option>
                                        {addressList.map((item) => (
                                            <option key={item.code} value={item.name}>
                                                {item.name}
                                            </option>
                                        ))}

                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Avatar</label>
                                    <div className="avatar-preview mb-3 rounded">
                                        <img src="https://via.placeholder.com/200" alt="avatar" id="avatar-preview" className="rounded" />
                                    </div>

                                    <label className="btn btn-warning" htmlFor="input">
                                        Chọn ảnh
                                    </label>
                                    <input type="file" id="input" className="d-none" />
                                </div>
                                <div className="mb-3">
                                    <label className="col-form-label">Password</label>
                                    <div className="">
                                        <button type="button" className="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#modal-change-password">
                                            Đổi mật khẩu
                                        </button>
                                        <button className="btn btn-warning" id="btn-forgot-password">
                                            Quên mật khẩu
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div className="text-center mt-3">
                                <button className="btn btn-secondary btn-back" type="button" onClick={() => navigate("/users")} >Quay lại</button>
                                <button className="btn btn-success" id="btn-save" type="submit">Cập nhật</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}

export default UserDetail