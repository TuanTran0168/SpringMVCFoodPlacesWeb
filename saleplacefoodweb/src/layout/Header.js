import { useState } from "react";
import { Button, Col, Container, Form, Nav, NavDropdown, Navbar, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";

const Header = () => {

    const [kw, setKw] = useState("");
    // const [fromPice,setFromPeice] = useState("");
    const nav = useNavigate();

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    return <>
        <Navbar expand="lg" className="navbar navbar-expand-sm bg-dark navbar-dark">
            <Container>
                <Navbar.Brand href="#">PLACE FOOD WEBSITE</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link className="nav-link" to="/">Home</Link>
                        <Link className="nav-link text-success" to="/login">Login</Link>
                        <Link className="nav-link text-danger" to="/register">Register</Link>
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
                    </Row>
                </Form>
            </Container>
        </Navbar>
    </>
}
export default Header;