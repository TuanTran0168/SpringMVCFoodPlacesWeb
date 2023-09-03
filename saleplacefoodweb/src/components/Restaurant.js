import { useEffect, useState } from "react";
import { Button, Card, Col, Form, Row } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import '../resources/css/Restaurant.css'

const Restaurant = () => {

    const [restaurant, setRestaurant] = useState(null);
    const [q] = useSearchParams();
    const [restaurantName, setRestaurantName] = useState("");
    const [location, setLocation] = useState("");

    useEffect(() => {
        const loadRestaurant = async () => {
            try {
                let e = `${endpoints['restaurant']}?`;
                let page = q.get("page");
                let restaurantName = q.get("restaurantName");
                let location = q.get("location");
                if (page !== null) {
                    e += `page=${page}&`;
                }
                if (restaurantName !== null) {
                    e += `restaurantName=${restaurantName}&`;
                }
                if (location !== null) {
                    e += `location=${location}`;
                }
                let res = await Apis.get(e);

                setRestaurant(res.data);
                console.log(res.data)
            } catch (ex) {
                console.error(ex);
            }
        }
        loadRestaurant();
    })

    if(restaurant === null){
        return <MySpinner />
    }


    return <>
        <h1 className="text-center text-primary">Danh Sách Nhà Hàng</h1>
        <div className="home">
            <div className="find">
                <Form className="mt-3 mb-2" inline>
                    <Row>
                        <h5>Nhập đi</h5>
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                value={restaurantName}
                                onChange={e => setRestaurantName(e.target.value)}
                                placeholder="Nhập tên nhà hàng..." name="restaurantName"
                                className="f mr-sm-2"
                            />
                            <Form.Control
                                type="text"
                                value={location}
                                onChange={e => setLocation(e.target.value)}
                                placeholder="Nhập vị trí..." name="location"
                                className="f mr-sm-2"
                            />
                            {/* <Form.Control
                                type="number"
                                // value={toPrice}
                                // onChange={e => setToPrice(e.target.value)}
                                placeholder="Nhập nhập giá tối đa..." name="toPrice"
                                className="f mr-sm-2"
                            /> */}
                            <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                        </Col>
                        </Col>
                    </Row>
                </Form>
            </div>
            <div className="fooditems">
                <Row>
                    {restaurant.map(r => {
                        // let url = `/fooddetail/${r.}`; chi tiết nhà hàng ở đây
                        return <Col xs={12} md={3} className="m-3 mt-2 mb-2">
                            <Card className="mt-3" style={{ width: '18rem' }}>
                                <Card.Img className="img_res" variant="top" src={r.avatar} />
                                <Card.Body>
                                    <div className="flex" >
                                        <div>
                                            <Card.Title>{r.restaurantName}</Card.Title>
                                            <Card.Text>
                                               Vị trí: {r.location}
                                            </Card.Text>
                                        </div>
                                        <div className="description" >
                                            <Card.Text>{r.mapLink}</Card.Text>
                                        </div>
                                    </div>
                                    {/* <Button onClick={() => { order(f) }} variant="success">ADD TO CART</Button> */}
                                    <Link to="#" variant="primary" className="btn-food btn btn-primary">Xem chi tiết</Link>
                                </Card.Body>
                            </Card>
                        </Col>

                    })}

                </Row>
            </div>
        </div>
    </>

}
export default Restaurant;