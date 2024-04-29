import axios from "axios";
import { jwtDecode } from "jwt-decode";

const baseUrl = "http://localhost:8080/";

export const getDecodedToken = () => {
  return jwtDecode(localStorage.getItem("token"));
};

export const getHeader = () => {
  const token = localStorage.getItem("token");
  return {
    Authorization: `Bearer ${token}`,
  };
};

export async function login(data) {
  try {
    return await axios.post(baseUrl + "auth/login", data);
  } catch (error) {
    console.log("Error while login", error);
  }
}

export function logout() {
  localStorage.setItem("token", "");
}

export async function getMenuTitles() {
  try {
    return await axios.get(baseUrl + "menu-titles");
  } catch (error) {
    console.log("Error while getting menu titles", error);
  }
}

export async function addMenuTitle(data) {
  try {
    await axios.post(baseUrl + "menu-titles", data, {
      headers: getHeader(),
    });
  } catch (error) {
    console.log("Error while adding menu title : ", error);
  }
}

export async function getMenuItems(menutitle) {
  try {
    return await axios.get(baseUrl + `${menutitle}/menu-items`);
  } catch (error) {
    console.log("Error while getting menu items : ", error);
  }
}

export async function addMenuItem(data) {
  try {
    await axios.post(baseUrl + "menu-items", {
      headers: getHeader(),
    });
  } catch (error) {
    console.log("Error while adding menu title : ", error);
  }
}
