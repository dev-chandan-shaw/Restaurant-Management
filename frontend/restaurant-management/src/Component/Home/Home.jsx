import React, { useEffect, useState } from "react";
import MenuTitleCard from "../MenuTitleCard/MenuTitleCard";
import { useDispatch } from "react-redux";
import { login as authLogin, logout } from "../../Store/authSlice";
import AddMenuTitle from "../AddMenuTitle";
import { Link } from "react-router-dom";
import Admin from "./Admin";
import { jwtDecode } from "jwt-decode";
import LoginUser from "../../User/LoginUser";

const Home = () => {
  const userData = JSON.parse(localStorage.getItem("userData"));
  const dispatch = useDispatch()
  const[role, setRole] = useState('');
  function removeExpiredToken() {
    const token = localStorage.getItem('token');
    if (token) {
        const decoded_token = jwtDecode(token)
        setRole(decoded_token.role.authority)
        const expirationTime = decoded_token.exp * 1000; 
        if (Date.now() > expirationTime) {
            localStorage.removeItem('token');
            dispatch(logout())
        } else {
            console.log('Token is still valid.');
        }
    } else {
        console.log('No token found in local storage.');
    }
}

useEffect(() => {
  removeExpiredToken()
},[])

  return (
    <div>{role === "ROLE_ADMIN" ? <Admin /> :  <MenuTitleCard/>}</div>
  );
};

export default Home;
