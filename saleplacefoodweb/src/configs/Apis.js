import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/SpringFoodPlacesWeb";
const SERVER = "http://localhost:8080";

export const endpoints = {
    "fooditems":`${SERVER_CONTEXT}/api/restaurantManager/foodItems/`,
    "categories":`${SERVER_CONTEXT}/api/restaurantManager/categori/`,
    "register":`${SERVER_CONTEXT}/api/registerUser/`,
    "login":`${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/` //lấy user hiện đang login
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL:SERVER
})

