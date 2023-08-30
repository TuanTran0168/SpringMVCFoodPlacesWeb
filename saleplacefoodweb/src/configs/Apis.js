import axios from "axios";

const SERVER_CONTEXT = "/SpringFoodPlacesWeb";
const SERVER = "http://localhost:8080";

export const endpoints = {
    "fooditems":`${SERVER_CONTEXT}/api/restaurantManager/foodItems/`,
    "categories":`${SERVER_CONTEXT}/api/restaurantManager/categori/`,
    "register":`${SERVER_CONTEXT}/api/restaurantManager/register/`
}

export default axios.create({
    baseURL:SERVER
})

