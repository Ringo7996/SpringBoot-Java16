import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
// Use useForm hook from react-hook-form to create a form and handle validation
import { useForm } from "react-hook-form";
import axios from 'axios';
import * as yup from "yup";
import { yupResolver } from '@hookform/resolvers/yup';

const API_URL = "http://localhost:8080/users/create"; // TODO:change to user api url
function UserCreate() {
  const [addressList, setAddressList] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getProvinces();
    // TODO: call api to get province list
    // url: https://provinces.open-api.vn/api/p/
  }, []);


  const schema = yup.object({
    name: yup.string().required("Name must not empty"),
    email: yup.string().matches(/^[a-zA-Z0-9._%+=]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/, "Not valid email")
      .required("Email must not empty")

    //TO DO: Khai báo thêm các trường khác
  }).required();


  async function getProvinces() {
    try {
      let res = await axios.get("https://provinces.open-api.vn/api/p/")
        let provinces = res.data;
        setAddressList(provinces);
    } catch (error) {
      console.error(error)
    }
  }

  // Sử dụng: useForm hook
  // register là function dùng để gán cho các input field để hook-form có thể theo dõi sự thay đổi của input field
  // dùng register thì không cần viết các sự kiện onchange cho các input field
  // handleSubmit: function khi submit form
  // errors: thuộc tính trong formState object, dùng để chứa các validation errors nếu có
  const { register, handleSubmit, formState: { errors } } = useForm({
    resolver: yupResolver(schema),
    mode:"all"
  });


  const onSubmit = async data => {
    console.log(data)
    try {
      let res = await axios.post(API_URL, data);

      if (res.status === 200) {
        alert(`Create user successfully`);
        setTimeout(() => {
          navigate(`/users`)
        })
      } else {
        console.log(res.message)
      }
    } catch (error) {
      console.error(error);
    }

    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("address").value = "";
    document.getElementById("password").value = "";

    // TODO: write code to submit form. Ex: axios.post(API_URL, data)
  }

  return (
    <>
      <div className="container mt-5 mb-5">
        <h2 className="text-center text-uppercase mb-3">Create user</h2>

        <div className="row justify-content-center">
          <div className="col-md-6">
            <form onSubmit={handleSubmit(onSubmit)}>
              <div className="bg-light p-4">
                <div className="mb-3">

                  <label className="col-form-label">Name</label>
                  <input
                    type="text"
                    id="name"
                    className="form-control"
                    {...register("name")}
                  />
                  <p className="text-danger">{errors.name?.message}</p>
                </div>
                <div className="mb-3">

                  <label className="col-form-label">Email</label>
                  <input
                    type="text"
                    id="email"
                    className="form-control"
                    {...register("email")}
                  // TODO: sử dụng register để đăng kí thuộc tính để theo dõi trong form
                  />
                  <p className="text-danger">{errors.email?.message}</p>
                </div>
                <div className="mb-3">


                  <label className="col-form-label">Phone</label>
                  <input
                    type="text"
                    id="phone"
                    className="form-control"
                    {...register("phone")}
                  // TODO: sử dụng register để đăng kí thuộc tính để theo dõi trong form
                  />
                  <p className="text-danger">{errors.phone?.message}</p>
                </div>


                <div className="mb-3">
                  <label className="col-form-label">Address</label>
                  <select
                    className="form-select"
                    {...register("address")}
                    id="address"
                  // TODO: sử dụng register để đăng kí thuộc tính để theo dõi trong form
                  >
                    <option hidden value="">
                      Choose province
                    </option>
                    {addressList.map((item) => (
                      <option key={item.code} value={item.name}>
                        {item.name}
                      </option>
                    ))}
                  </select>
                  <p className="text-danger">{errors.address?.message}</p>
                </div>


                <div className="mb-3">
                  <label className="col-form-label">Password</label>
                  <input
                    type="text"
                    id="password"
                    className="form-control"
                    {...register("password")}
                  // TODO: sử dụng register để đăng kí thuộc tính để theo dõi trong form
                  />
                  <p className="text-danger">{errors.password?.message}</p>
                </div>
              </div>


              <div className="text-center mt-3">
                <button
                  className="btn btn-secondary btn-back"
                  type="button"
                  onClick={() => navigate("/users")}
                >
                  Back
                </button>
                <button className="btn btn-success" type="submit" id="btn-save">
                  Create User
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default UserCreate;
