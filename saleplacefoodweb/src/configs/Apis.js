import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/SpringFoodPlacesWeb";
const SERVER = "http://localhost:8080";

export const endpoints = {
    "fooditems":`${SERVER_CONTEXT}/api/foodItems/`,
    "categories":`${SERVER_CONTEXT}/api/restaurantManager/categories/`,
    "register":`${SERVER_CONTEXT}/api/register/`,
    "login":`${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`, //lấy user hiện đang login
    "pay": `${SERVER_CONTEXT}/api/pay/`,
    "detail": (foodId) => `${SERVER_CONTEXT}/api/foodItems/${foodId}/`,
    "comments": (foodId) => `${SERVER_CONTEXT}/api/foodItems/${foodId}/comments/`,
    "add-comment": `${SERVER_CONTEXT}/api/add-comment/`,
    "restaurant": `${SERVER_CONTEXT}/api/restaurants/`,
    "restaurant_detail":(restaurantId) => `${SERVER_CONTEXT}/api/restaurants/${restaurantId}/`
    
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

