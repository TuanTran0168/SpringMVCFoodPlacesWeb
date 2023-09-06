import { useContext, useEffect, useState } from "react";
import { Alert, Button, Card, Carousel, Col, Form, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import '../resources/css/Home.css'
import { MyCartContext } from "../App";
import cookie from "react-cookies";

const Home = () => {

    const [foodItems, setFoodItems] = useState(null);
    const [, cartDispatch] = useContext(MyCartContext);
    const [q] = useSearchParams();
    const [restaurant, setRestaurant] = useState(null);

    // const currentPage = useLocation();
    const [kw, setKw] = useState("");
    const [fromPrice, setFromPrice] = useState("");
    const [toPrice, setToPrice] = useState("");
    const [page, setPage] = useState("");
    const nav = useNavigate();


    const search = (evt) => {
        evt.preventDefault();
        let find = "/?"
        if (kw !== "") {
            find += `kw=${kw}&`
        }
        if (fromPrice !== "") {
            find += `formPrice=${fromPrice}&`
        }
        if (toPrice !== "") {
            find += `toPrice=${toPrice}`
        }
        // if (page !== "") {
        //     find += `page=${page}`
        // }
        nav(find)
    }

    useEffect(() => {
        const loadFoodItems = async () => {
            try {
                let e = `${endpoints['fooditems']}?`;
                let nameFoodItem = q.get("kw");
                let fromPriceFood = q.get("formPrice")
                let toPriceFood = q.get("toPrice")
                // let page = q.get("page")

                if (nameFoodItem !== null) {
                    e += `kw=${nameFoodItem}&`;
                }
                if (fromPriceFood !== null) {
                    e += `formPrice=${fromPriceFood}&`;
                }
                if (toPriceFood !== null) {
                    e += `toPrice=${toPriceFood}&`;
                }
                // if (page !== null) {
                //     e += `page=${page}`;
                // }

                let res = await Apis.get(e);

                setFoodItems(res.data);
                console.log(res.data)
            } catch (ex) {
                console.error(ex);
            }
        }

        const loadRestaurant = async () => {
            try {
                let e = `${endpoints['restaurant']}?`;
                let restaurantName = q.get("kw");
                // let location = q.get("location");
                if (page !== null) {
                    e += `page=${page}&`;
                }
                if (restaurantName !== null) {
                    e += `restaurantName=${restaurantName}&`;
                }
                // if (location !== null) {
                //     e += `location=${location}`;
                // }
                let res = await Apis.get(e);

                setRestaurant(res.data);
                // console.log(res.data)
            } catch (ex) {
                console.error(ex);
            }
        }

        loadFoodItems();
        loadRestaurant();

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
                "foodId": foodItem.foodId,
                "foodName": foodItem.foodName,
                "quantity": 1,
                "unitPrice": foodItem.price
            }
        }

        cookie.save("cart", cart);
    }
    if (foodItems.length === 0 && restaurant.length)
        return <Alert variant="info" className="mt-2">Không có sản phẩm nào!</Alert>

    return <>
        <div>
            <Carousel data-bs-theme="dark">
                {restaurant.map(r => {

                    return <Carousel.Item>
                        <h1 className="text-center text-danger">{r.restaurantName}</h1>
                        <img
                            className="carol_img d-block w-100"
                            src={r.avatar}
                            alt={r.restaurantName}
                        />
                        <Carousel.Caption className="caption_res">
                            <h5>First slide label</h5>
                            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                })}

            </Carousel>
        </div>

        <div className="home">
            <div className="find">
                <Form onSubmit={search} className="mt-3 mb-2" inline>
                    <Row>
                        <h5>Nhập đi</h5>
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                value={kw}
                                onChange={e => setKw(e.target.value)}
                                placeholder="Nhập ten mon an..." name="kw"
                                className="f mr-sm-2"
                            />
                            <Form.Control
                                type="number"
                                value={fromPrice}
                                onChange={e => setFromPrice(e.target.value)}
                                placeholder="Nhập giá từ..." name="fromPrice"
                                className="f mr-sm-2"
                            />
                            <Form.Control
                                type="number"
                                value={toPrice}
                                onChange={e => setToPrice(e.target.value)}
                                placeholder="Nhập nhập giá tối đa..." name="toPrice"
                                className="f mr-sm-2"
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                            <Link className="text-primary icon_avatar_link" to="/restaurant">List Restaurant</Link>
                        </Col>
                    </Row>
                </Form>
            </div>
            <div className="fooditems">
                <Row>
                    {foodItems.map(f => {
                        let url = `/fooddetail/${f.foodId}`;
                        return <Col xs={12} md={3} className="m-3 mt-2 mb-2">
                            <Card className="mt-3" style={{ width: '18rem' }}>
                                <Link to={url}><Card.Img variant="top" src={f.avatar} /></Link>
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
                                    <div className="btn_all">
                                        <Button onClick={() => { order(f) }} variant="success">ADD TO CART</Button>
                                        <Link to={url} variant="primary" className="btn-food btn btn-primary">Xem chi tiết</Link>
                                    </div>
                                </Card.Body>
                            </Card>
                        </Col>

                    })}
                </Row>
            </div>
        </div>
    </>
}
export default Home;