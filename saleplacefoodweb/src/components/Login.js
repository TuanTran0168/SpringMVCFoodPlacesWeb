import { useContext, useState } from "react";
import { MyUserContext } from "../App";
import { Alert, Button, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { Link, Navigate, useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";

const Login = () => {

    const [loading, setLoading] = useState(false);
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [q] = useSearchParams();
    const [err, setErr] = useState(null);

    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                setLoading(true);
                //lấy token login
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });

                //cookie khác của thầy, xem lại nếu lỗi.....:)))))) -------------đã fix
                cookie.save("token", res.data);    //lưu cái res.data kia bằng biến token vào cookie 

                let { data } = await authApi().get(endpoints['current-user']);
                cookie.save("user", data); //lưu cái data kia bằng biến user vào cookie 

                dispatch({
                    "type": "login",
                    "payload": data
                });

            } catch (ex) {
                // console.log(ex);
                // console.log(ex.request.responseText)
                // console.log(ex.request.status)
                //Xử lý thêm chỗ này để xuất lỗi
                setLoading(false);
                setErr(ex.request.responseText);
            }
        }
        process();

    }


    if (user !== null) {
        let next = q.get("next") || "/";
        return <Navigate to={next} />;

    }
    return <>
        <h1 className="text-center text-info">LOGIN</h1>

        <Form onSubmit={login}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={username} onChange={e => setUsername(e.target.value)} type="text" placeholder="Tên đăng nhập" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={password} onChange={e => setPassword(e.target.value)} type="password" placeholder="Mật khẩu" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                {loading === true ? <MySpinner /> : <>
                <Button variant="info" type="submit">Đăng nhập</Button> <span>Chưa có tài khoản? <Link to="/register">Đăng ký tại đây</Link> <Link to="/changPassword">Quên mật khẩu?</Link></span>
                </>}
            </Form.Group>
            {err !== null ? <Alert className="alert-danger">{err}</Alert> : ""}

        </Form>
    </>
}
export default Login;