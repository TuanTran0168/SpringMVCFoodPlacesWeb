import { useContext, useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Link, useParams } from "react-router-dom";
import { MyCartContext, MyUserContext } from "../App";
import { Button, Col, Image, Row } from "react-bootstrap";
import MySpinner from "../layout/MySpinner";
import '../resources/css/FoodItemDetail.css'
import cookie from "react-cookies";

const FoodItemDetail = () => {

    const [user,] = useContext(MyUserContext);
    const { foodId } = useParams();
    const [, cartDispatch] = useContext(MyCartContext);
    const [foodItem, setFoodItem] = useState(null);
    // const [comments, setComments] = useState(null);

    useEffect(() => {
        const loadFood = async () => {
            let { data } = await Apis.get(endpoints['detail'](foodId));
            setFoodItem(data);
        }

        // const loadComments = async () => {
        //     let {data} = await Apis.get(endpoints['comments'](foodId));
        //     setComments(data);
        // }

        loadFood();
        // loadComments();
    }, [foodId]);

    const order = (foodItem) => {
        cartDispatch({
            "type": "inc",
            "payload": 1
        })


        let cart = cookie.load("cart") || null;
        if (cart == null)
            cart = {};

        if (foodItem.foodId in cart) { // sản phẩm có trong giỏ
            cart[foodItem.foodId]["quantity"] += 1;
        } else { // sản phẩm chưa có trong giỏ
            cart[foodItem.foodId] = {
                "foodId": foodItem.foodId,
                "foodName": foodItem.foodName,
                "quantity": 1,
                "unitPrice": foodItem.price
            }
        }

        cookie.save("cart", cart);
    }

    if (foodItem === null)
        return <MySpinner />;


    let url = `/login?next=/products/${foodId}`;
    return <>
        <h1 className="text-center text-info mt-2">CHI TIẾT SẢN PHẨM ({foodItem.foodName})</h1>
        <Row>
            <Col md={5} xs={6}>
                <Image src={foodItem.avatar} rounded fluid />
            </Col>
            <Col md={5} xs={6}>
                <h2 className="text-danger">{foodItem.foodName}</h2>
                <p>{foodItem.description}</p>
                <h3>{foodItem.price} VNĐ</h3>
                <Button onClick={() => { order(foodItem) }} variant="success">ADD TO CART</Button>
                <div className="info_restaurant">
                   <Link to="#"><Image className="img_restaurant" src={foodItem.categoryfoodId.restaurantId.avatar} roundedCircle /></Link>
                    <h3>{foodItem.categoryfoodId.restaurantId.restaurantName}</h3>
                </div>
            </Col>
        </Row>
        <hr />
    </>
}
export default FoodItemDetail;