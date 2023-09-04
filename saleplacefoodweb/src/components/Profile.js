import { useRef, useState } from "react";
import { Button, Col, Container, Form, Image, Row } from "react-bootstrap";
import cookie from "react-cookies";
// import img from '../resources/img/healthy-lunch-go-packed-lunch-box.jpg';
import '../resources/css/Profile.css';
import MySpinner from "../layout/MySpinner";
import Apis, { endpoints } from "../configs/Apis";
import { Link, useNavigate } from "react-router-dom";

const Profile = () => {


    const [current_user,] = useState(cookie.load("user") || null);
    const avatar = useRef();
    const [current_avatar, setCurrent_avatar] = useState(current_user.avatar);
    const [user, setUser] = useState({
        "firstname": "",
        "lastname": "",
        "location": "",
        "email": "",
        "phonenumber": "",
        "avatar": current_user.avatar
    });
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setUser(current => {
            return { ...current, [field]: evt.target.value }
        })
    }

    const updateAvatar = (avatar) => {
        console.log(avatar[0]);
        setCurrent_avatar(avatar[0]);
    }

    const updateUser = (evt) => {
        evt.preventDefault();
        setLoading(true);
        const process = async () => {
            let form = new FormData();
            for (let field in user) {
                if (field !== "confirmPass") {
                    form.append(field, user[field]);
                }
            }


            form.append("avatar", avatar.current.files[0]);
            let res = await Apis.post(endpoints['register'], form);
            if (res.status === 201) {
                nav("/profile");
            }
            // else
            // setErr("Hệ thống bị lỗi!");
        }
        process();

    }

    if (current_user === null) {
        return <>
            <h1>Vui lòng đăng nhập</h1>
        </>
    }

    return <>
        <Form onSubmit={updateUser}>
            <h1 className="text-center text-info">Your Profile</h1>

            <div className="contain_info">
                <div className="contain_info_1">
                    <Link className="nav-link text-success" to="/profile">User Info</Link>
                    <Link className="nav-link text-success" to="#">Change Password</Link>
                    <Link className="nav-link text-success" to="#">Order History</Link>
                    <Link className="nav-link text-success" to="#">Register Restaurant</Link>
                </div>
                <div className="contain_info_2">
                    <div className="avatar">
                        <Image src={current_avatar} rounded />
                        <Form.Control className="avatar_input" accept=".jpg, .jpeg, .png, .gif, .bmp" type="file" onChange={(e) => updateAvatar(e.target.files)} ref={avatar} />
                    </div>
                    <div className="info">
                        <hr />
                        <h4>User Info</h4>
                        <br />
                        <Form.Group className="mb-3" controlId="formFirstName">
                            <Form.Label>Your First Name</Form.Label>
                            <Form.Control
                                onChange={(e) => change(e, "firstname")}
                                type="text"
                                defaultValue={current_user.firstname}
                                aria-label="Disabled input example"
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formLastName">
                            <Form.Label>Your Last Name</Form.Label>
                            <Form.Control
                                onChange={(e) => change(e, "lastname")}
                                type="text"
                                value={current_user.lastname}
                                aria-label="Disabled input example"
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formUsername">
                            <Form.Label>Your Username</Form.Label>
                            <Form.Control
                                type="text"
                                value={current_user.username}
                                readOnly
                                aria-label="Disabled input example"
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formLocation">
                            <Form.Label>Your Location</Form.Label>
                            <Form.Control
                                onChange={(e) => change(e, "location")}
                                type="text"
                                value={current_user.location}
                                aria-label="Disabled input example"
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Your Email</Form.Label>
                            <Form.Control
                                onChange={(e) => change(e, "email")}
                                type="email"
                                value={current_user.email}
                                aria-label="Disabled input example"
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formPhoneNumber">
                            <Form.Label>Your Phone Number</Form.Label>
                            <Form.Control
                                onChange={(e) => change(e, "phonenumber")}
                                type="text"
                                value={current_user.phonenumber}
                                aria-label="Disabled input example"
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formRole">
                            <Form.Label>Type User</Form.Label>
                            <Form.Control
                                type="text"
                                value={current_user.roleId.roleName}
                                aria-label="Disabled input example"
                                readOnly
                            />
                        </Form.Group>
                        <Form.Group className="mb-3">
                            {loading === true ? <MySpinner /> : <div className="btn_luu"><Button className="text-center" variant="info" type="submit">Lưu</Button></div>}

                        </Form.Group>

                    </div>
                </div>
            </div>
        </Form>
    </>
}
export default Profile;