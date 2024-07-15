import axios from "axios";

console.log(import.meta.env)
axios.defaults.baseURL = import.meta.env

export const setAuthorization = token => {
  axios.defaults.headers["Authorization"] = `Bearer ${token}`
}

export const apiLogout = () => {
  axios.defaults.headers["Authorization"] = ""
}