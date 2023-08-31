import { useContext, useEffect, useState } from "react";
import { Alert, Button, Card, Col, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import '../resources/css/Home.css'
import { MyCartContext } from "../App";
import cookie from "react-cookies";

const Home = () => {

    const [foodItems, setFoodItems] = useState(null);
    const [, cartDispatch] = useContext(MyCartContext);
    const [q] = useSearchParams();

    useEffect(() => {
        const loadFoodItems = async () => {
            try {
                let e = endpoints['fooditems'];
                let nameFoodItem = q.get("kw");

                if (nameFoodItem !== null) {
                    e = `${e}?kw=${nameFoodItem}`;
                }

                let res = await Apis.get(e);
                setFoodItems(res.data);
                console.log(res.data)
            } catch (ex) {
                console.error(ex);
            }
        }

        loadFoodItems();
    }, [q])


    if (foodItems === null) {
        return <MySpinner />
    }

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
                "id": foodItem.foodId,
                "name": foodItem.foodName,
                "quantity": 1,
                "unitPrice": foodItem.price
            }
        }

        cookie.save("cart", cart);

        console.info(cart);
    }
    if (foodItems.length === 0)
        return <Alert variant="info" className="mt-2">Không có sản phẩm nào!</Alert>

    return <>
        <Row>
            <Col xs={12} md={3} className="mt-2 mb-2">
                <Card className="mt-3" style={{ width: '18rem' }}>
                    <Card.Img className="card-fooditem" variant="top" src={foodItems[1].avatar} />
                    <Card.Body>
                        <div className="flex">
                            <div>
                                <Card.Title>Pizza</Card.Title>
                                <Card.Text>
                                    119999 VNĐ
                                </Card.Text>
                            </div>
                            <div className="description">
                                <Card.Text>Great Food</Card.Text>
                            </div>
                        </div>
                        <Button variant="primary">Buy</Button>
                    </Card.Body>
                </Card>
            </Col>
            {foodItems.map(f => {
                // let url = ``; chi tiet san pham
                return <Col xs={12} md={3} className="mt-2 mb-2">
                    <Card className="mt-3" style={{ width: '18rem' }}>
                        <Card.Img variant="top" src={f.avatar} />
                        <Card.Body>
                            <div className="flex" >
                                <div>
                                    <Card.Title>{f.foodName}</Card.Title>
                                    <Card.Text>
                                        {f.price} VNĐ
                                    </Card.Text>
                                </div>
                                <div className="description" >
                                    <Card.Text>{f.description}</Card.Text>
                                </div>
                            </div>
                            <Button onClick={() => { order(f) }} variant="primary">ADD TO CART</Button>
                        </Card.Body>
                    </Card>
                </Col>

            })}

        </Row>
    </>
}
export default Home;