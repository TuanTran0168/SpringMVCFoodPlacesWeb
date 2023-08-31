import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './layout/Header';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Footer from './layout/Footer';
import Home from './components/Home';
import Register from './components/Register';
import { createContext, useReducer } from 'react';
import Login from './components/Login';
import MyUserReducer from './reducers/MyUserReducer';
import MyCartCounterReducer from './reducers/MyCartCounterReducer';
import cookie from "react-cookies";
import Cart from './components/Cart';
import Profile from './components/Profile';



export const MyUserContext = createContext();
export const MyCartContext = createContext();

function App() {

  const countCart = () => {
    let cart = cookie.load("cart") || null;
    if (cart !== null)
      return Object.values(cart).reduce((init, current) => init + current["quantity"], 0);
    return 0;
  }

  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  const [cartCounter, cartDispatch] = useReducer(MyCartCounterReducer, countCart());

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
        <BrowserRouter>
          <Header />
          <Container>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/register" element={<Register />} />
              <Route path="/login" element={<Login />} />
              <Route path="/cart" element={<Cart />} />
              <Route path="/profile" element={<Profile />}/>
            </Routes>
          </Container>
          <Footer />
        </BrowserRouter>
      </MyCartContext.Provider>
    </MyUserContext.Provider>
  );
}

export default App;
