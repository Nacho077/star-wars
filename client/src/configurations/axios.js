import axios from "axios";

axios.defaults.baseURL = "http://localhost:8080"

export const setAuthorization = token => {
  axios.defaults.headers["Authorization"] = `Bearer ${token}`
}

export const apiLogout = () => {
  axios.defaults.headers["Authorization"] = ""
}