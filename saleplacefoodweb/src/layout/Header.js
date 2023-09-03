import { useContext } from "react";
import { Badge, Button, Container, Image, Nav, NavDropdown, Navbar} from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyCartContext, MyUserContext } from "../App";
import '../resources/css/Header.css'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

const Header = () => {

    const [user, dispatch] = useContext(MyUserContext);
    const [cartCounter, ] = useContext(MyCartContext);
    const nav = useNavigate();


    const logout = () => {
        dispatch({
            "type": "logout"
        })
        nav("/")
    }

    return <>
        <Navbar expand="lg" className="navbar navbar-expand-sm bg-dark navbar-dark header">
            <Container>
                <Navbar.Brand href="#">PLACE FOOD WEBSITE</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link className="nav-link" to="/">Home</Link>

                        {user === null ? <>
                            <Link className="nav-link text-success" to="/login">Login</Link>
                            <Link className="nav-link text-danger" to="/register">Register</Link>
                        </> :
                            <>
                                <Link className="nav-link text-danger" to="/profile">Hi {user.firstname} {user.lastname}!</Link>
                                <Button variant="secondary" onClick={logout}>Logout</Button>
                            </>

                        }
                        <Link className="nav-link text-danger" to="/cart">&#128722; <Badge bg="danger">{cartCounter}</Badge></Link>
                        <Link className="nav-link text-danger icon_avatar_link" to="/profile">
                            {/* <Image className="icon_avatar" src={user.avatar} roundedCircle /> */}
                        </Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    </>
}
export default Header;