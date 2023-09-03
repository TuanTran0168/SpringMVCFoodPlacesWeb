import { useContext, useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import MySpinner from "../layout/MySpinner";
import Apis, { endpoints } from "../configs/Apis";
import { Navigate, useNavigate } from "react-router-dom";
import { MyUserContext } from "../App";

const Register = () => {

    const [loading, setLoading] = useState(false);
    const [current_user,] = useContext(MyUserContext); 
    const avatar = useRef();
    const nav = useNavigate();
    const [err,setErr] = useState(null); 
    const [user,setUser] = useState({
        "username": "", 
        "password": "", 
        "firstname": "", 
        "lastname": "", 
        "email": "",
        "phonenumber": "",
        "confirmPass": ""
    });

    if(current_user !== null){
        // alert("Vui lòng đăng xuất để đăng ký!!!");
        return <Navigate to="/" />
    }
    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setUser(current => {
            return {...current, [field]: evt.target.value}
        })
    }

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            for (let field in user)
                if (field !== "confirmPass")
                    form.append(field, user[field]);

            form.append("avatar", avatar.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['register'], form);
            if (res.status === 201) {
                nav("/login");
            } else
            setErr("Hệ thống bị lỗi!");
        }
        if (user.password === user.confirmPass)
            process();
        else {
            setErr("Mật khẩu KHÔNG khớp!");
        }
    }

    return <>
        <h1 className="text-center text-success">Register</h1>

        {err === null?"":<Alert variant="danger">{err}</Alert>}
        <Form onSubmit={register}>
            <Form.Group className="mb-3">
                <Form.Label>Tên</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "firstname")} placeholder="Tên" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Họ và chữ lót</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "lastname")} placeholder="Họ và chữ lót" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control type="email" onChange={(e) => change(e, "email")} placeholder="Email" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Điện thoại</Form.Label>
                <Form.Control type="tel" onChange={(e) => change(e, "phone")} placeholder="Điện thoại" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={user.username} onChange={(e) => change(e, "username")} type="text" placeholder="Tên đăng nhập" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={user.password} onChange={(e) => change(e, "password")} type="password" placeholder="Mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Xác nhận mật khẩu</Form.Label>
                <Form.Control value={user.confirmPass} onChange={(e) => change(e, "confirmPass")} type="password" placeholder="Xác nhận mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={avatar}  />
            </Form.Group>
            <Form.Group className="mb-3">
                {loading === true?<MySpinner />: <Button variant="info" type="submit">Đăng ký</Button>}
                
            </Form.Group>
        </Form>
    </>
}
export default Register;