import { useEffect, useState } from "react";
import { Alert, Button, Card, Col, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";

const Home = () => {

    const [foodItems, setFoodItems] = useState(null);
    const [q] = useSearchParams();

    useEffect(() => {
        const loadFoodItems = async () => {
            try {
                let e = endpoints['fooditems'];
                let nameFoodItem = q.get("kw");

                if (nameFoodItem !== null) {
                    e = `${e}?kw=${nameFoodItem}`;
                }

                let res = await Apis.get(e);
                setFoodItems(res.data);
                console.log(res.data)
            } catch (ex) {
                console.error(ex);
            }
        }

        loadFoodItems();
    }, [q])


    if (foodItems === null) {
        return <MySpinner />
    }

    if (foodItems.length === 0)
        return <Alert variant="info" className="mt-2">Không có sản phẩm nào!</Alert>

    return <>
    <Row>
        {foodItems.map(f => {
            // let url = ``; chi tiet san pham
            return <Col xs={12} md={3} className="mt-2 mb-2">
                <Card className="mt-3" style={{ width: '18rem' }}>
                <Card.Img variant="top" src={f.avatar} />
                <Card.Body>
                    <Card.Title>{f.foodName}</Card.Title>
                    <Card.Text>
                        {f.price}
                    </Card.Text>
                    <Button variant="primary">Buy</Button>
                </Card.Body>
            </Card>
            </Col>
            
        })}

        </Row>
    </>
}
export default Home;