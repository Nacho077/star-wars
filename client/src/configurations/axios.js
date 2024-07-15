import axios from "axios";

axios.defaults.baseURL = import.meta.env.VITE_API_BASE_URL

export const setAuthorization = token => {
  axios.defaults.headers["Authorization"] = `Bearer ${token}`
}

export const apiLogout = () => {
  axios.defaults.headers["Authorization"] = ""
}