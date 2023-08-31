import { useContext, useState } from "react";
import { Badge, Button, Col, Container, Form, Nav, NavDropdown, Navbar, Row } from "react-bootstrap";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { MyCartContext, MyUserContext } from "../App";

const Header = () => {

    const [user, dispatch] = useContext(MyUserContext);
    const [cartCounter, ] = useContext(MyCartContext);
    const [kw, setKw] = useState("");
    // const [fromPice,setFromPeice] = useState("");
    const nav = useNavigate();
    const currentPage = useLocation();
    console.log(currentPage.pathname);
    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    return <>
        <Navbar expand="lg" className="navbar navbar-expand-sm bg-dark navbar-dark">
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

                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">
                                Another action
                            </NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">
                                Separated link
                            </NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                <Form onSubmit={search} inline>
                    <Row>
                        {
                            currentPage.pathname === "/" ? <>
                            <Col xs="auto">
                            <Form.Control
                                type="text"
                                value={kw}
                                onChange={e => setKw(e.target.value)}
                                placeholder="Nhập ten mon an..." name="kw"
                                className=" mr-sm-2"
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                        </Col>
                            </>: <>

                            </>
                        }
                        
                        
                    </Row>
                </Form>
            </Container>
        </Navbar>
    </>
}
export default Header;