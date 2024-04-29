import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { login as authLogin } from "../Store/authSlice";
import { login } from "../Backend/config";
import { jwtDecode } from "jwt-decode";

const LoginUser = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((previousData) => ({ ...previousData, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await login(formData);
    console.log(response);
    if (response.status === 200) {
      dispatch(authLogin(response.data.token, response.data.userData))
      navigate("/");
      const decoded_token = jwtDecode(response.data.token)
      console.log(decoded_token);
    } else {
      navigate("/login")
    }
  };

  return (
    <div className="m-auto my-10 p-10 border shadow-md w-[350px]">
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="email">Email</label>
          <input
            type="text"
            name="email"
            value={formData.email}
            onChange={handleInputChange}
            className="border p-1 w-full ring-inset rounded-sm block ring-1"
          />
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleInputChange}
            className="border p-1 w-full ring-inset rounded-sm block ring-1"
          />
        </div>
        <div className="mt-6 flex items-center justify-end gap-x-6">
          <Link
            to="/"
            className="text-sm font-semibold leading-6 text-gray-900"
          >
            Cancel
          </Link>
          <button
            type="submit"
            className="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            Save
          </button>
          
        </div>
        <p className="mt-6 text-center">Don&apos;t have account? <Link to={"/signup"} className="text-blue-500 underline">signup</Link></p>
          
      </form>
    </div>
  );
};

export default LoginUser;
