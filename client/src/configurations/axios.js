import axios from "axios";

console.log(import.meta.env)
console.log(import.meta.env.VITE_API_BASE_URL)
axios.defaults.baseURL = import.meta.env.VITE_API_BASE_URL

export const setAuthorization = token => {
  axios.defaults.headers["Authorization"] = `Bearer ${token}`
}

export const apiLogout = () => {
  axios.defaults.headers["Authorization"] = ""
}