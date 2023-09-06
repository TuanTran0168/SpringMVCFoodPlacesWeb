import { useContext, useEffect, useState } from "react";
import { Accordion, Alert, Form, Image, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";


const Receipt = () => {

    const [receipt, setReceipt] = useState();
    const [user,] = useContext(MyUserContext);
    const [activeKey, setActiveKey] = useState(null);


    useEffect(() => {

        const loadReceipt = async () => {
            try {
                let userId = user.userId;
                let form = new FormData();
                form.append("userId", userId)

                let res = await authApi().get(endpoints["receipt"], form);
                setReceipt(res.data);
            } catch (err) {
                console.log(err);
            }
        }
        loadReceipt();
    }, [user])

    const handleAccordionClick = (eventKey) => {
        setActiveKey(eventKey === activeKey ? null : eventKey);
    };

    if (user == null)
        return <Alert>Vui long dang nhap</Alert>

    if (receipt === null)
        return <Alert>k có san pham</Alert>


    return <>

        <div>
            <h1 className="text-center text-primary">Trang Chi Tiết Hóa Đơn</h1>

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
                    {receipt === null ? <Alert classname="alert-success" >Bạn không có sản phẩm nào!!</Alert> : ""}
                    {receipt == null ? <MySpinner /> : Object.values(receipt).map(r => {
                        return <Accordion className="mt-2" activeKey={activeKey}>
                            <Accordion.Item eventKey={r.receiptId} onClick={() => handleAccordionClick(r.receiptId)}>
                                <Accordion.Header>Hóa Đơn {r.receiptId}</Accordion.Header>
                                <Accordion.Body>
                                    fadfasfsa
                                </Accordion.Body>
                            </Accordion.Item>
                        </Accordion>
                    })}

                </div>
            </div>
        </div>
    </>
}
export default Receipt;