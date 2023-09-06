import { Col, Form, Nav, Table } from "react-bootstrap";
import { Link } from "react-router-dom";

const ChangePassword = () => {
    return <>
        <h1 className="text-center text-primary">Đổi Mật Khẩu</h1>
        <div className="contain_info">
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
            <div className="contain_info_2">
                <Form>
                    <Form.Group className="mb-3">
                        <Form.Label>Tên nhà hàng</Form.Label>
                        <Form.Control type="text" placeholder="Tên nhà hàng" required />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Địa chỉ</Form.Label>
                        <Form.Control type="text" placeholder="Địa chỉ" required />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Ảnh đại diện</Form.Label>
                        <Form.Control type="file" />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        {/* {loading === true ? <MySpinner /> : <Button variant="info" type="submit">Gửi Yêu Cầu</Button>} */}

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
                            {/* {restaurant == null ? <MySpinner /> : Object.values(restaurant).map(r => {
                                return <tr>
                                    <td>{r.restaurantId}</td>
                                    <td>{r.restaurantName}</td>
                                    <td>{r.location}</td>
                                    <td>{r.confirmationStatus === true ? "Đã Xác Thực" : "Chưa được Xác Thực"}</td>
                                    <td>{r.userId.userId}</td>
                                </tr>
                            })}
                            {restaurant.length === 0 ?<tr><Alert>Bạn chưa đăng ký nhà hàng nào!</Alert></tr> : null} */}
                        </tbody>
                    </Table>

                </Col>
            </div>
        </div>


    </>
}
export default ChangePassword;