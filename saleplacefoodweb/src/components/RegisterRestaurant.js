import { useContext, useEffect, useRef, useState } from "react";
import { Alert, Button, Col, Form, Image, Nav, Row, Table } from "react-bootstrap";
import MySpinner from "../layout/MySpinner";
import Apis, { authApi, endpoints } from "../configs/Apis";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import img from '../resources/img/react_icon.png'
import '../resources/css/RegisterRestaurant.css'
import { MyUserContext } from "../App";

const RegisterRestaurant = () => {

    const [restaurant, setRestaurant] = useState();
    // const [q] = useSearchParams();
    const [user,] = useContext(MyUserContext);


    const loadRestaurant = async () => {
        try {
            let e = `${endpoints['restaurant']}?current_user_UserId=${user.userId}`;

            let res = await Apis.get(e);

            setRestaurant(res.data);
            console.log(res.data)
        } catch (ex) {
            console.error(ex);
        }
    }
    useEffect(() => {
        loadRestaurant();
    }, [])

    const [regi_restaurant, setRegi_Restaurant] = useState({
        "restaurantName": "",
        "location": ""
        // "avatar": ""
    });
    const avatar = useRef();
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();


    const register_restaurant = (evt) => {
        evt.preventDefault();
        setLoading(true);
        const process = async () => {
            let form = new FormData();

            form.append("restaurantName", regi_restaurant["restaurantName"]);
            form.append("location", regi_restaurant["location"]);



            form.append("avatar", avatar.current.files[0]);
            // console.log(form)
            let res = await authApi().post(endpoints['register-restaurant'], form);

            if (res.status === 201) {
                loadRestaurant()
                setLoading(false);
                // nav("/");
            }
        }
        process();

    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setRegi_Restaurant(current => {
            return { ...current, [field]: evt.target.value }
        })
    }

    if (user === null) {
        return <>
            <Alert className="alert-danger">Vui lòng <Link to="/login">đăng nhập</Link></Alert>
        </>
    }

    return <>
        <h1 className="text-center text-info">Đăng Ký Nhà Hàng</h1>
        <div className="contain_info ">

            <div className="contain_info_1">
                <Nav variant="tabs" defaultActiveKey="/home">
                    <Nav.Item className="nav-link text-success choose">
                        <Link to="/profile" >User Info</Link>
                    </Nav.Item>
                    <Nav.Item className="nav-link text-success choose">
                        <Link to="/changepassword" >Change Password</Link>
                    </Nav.Item>
                    <Nav.Item className="nav-link text-success choose">
                        <Link to="/receipt" >Order History</Link>
                    </Nav.Item>
                    <Nav.Item className="nav-link text-success choose">
                        <Link to="/register_restaurant" >Register Restaurant</Link>
                    </Nav.Item>
                </Nav>
            </div>
            <div>
                <Form onSubmit={register_restaurant}>
                    <Form.Group className="mb-3">
                        <Form.Label>Tên nhà hàng</Form.Label>
                        <Form.Control type="text" onChange={(e) => { change(e, "restaurantName") }} placeholder="Tên nhà hàng" required />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Địa chỉ</Form.Label>
                        <Form.Control type="text" onChange={(e) => { change(e, "location") }} placeholder="Địa chỉ" required />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Ảnh đại diện</Form.Label>
                        <Form.Control type="file" ref={avatar} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        {loading === true ? <MySpinner /> : <Button variant="info" type="submit">Gửi Yêu Cầu</Button>}

                    </Form.Group>

                </Form>
                <hr />

                <Col>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Tên Nhà Hàng</th>
                                <th>Địa Chỉ</th>
                                <th>Trạng thái</th>
                                <th>Chủ nhà hàng</th>
                            </tr>
                        </thead>
                        <tbody>
                            {restaurant == null ? <MySpinner /> : Object.values(restaurant).map(r => {
                                return <tr>
                                    <td>{r.restaurantId}</td>
                                    <td>{r.restaurantName}</td>
                                    <td>{r.location}</td>
                                    <td>{r.confirmationStatus === true ? "Đã Xác Thực" : "Chưa được Xác Thực"}</td>
                                    <td>{r.userId.userId}</td>
                                </tr>
                            })}
                        </tbody>
                    </Table>

                </Col>
            </div>

        </div>


    </>
}
export default RegisterRestaurant;