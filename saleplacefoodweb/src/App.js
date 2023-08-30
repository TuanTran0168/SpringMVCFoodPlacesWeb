import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './layout/Header';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Footer from './layout/Footer';
import Home from './components/Home';
import Register from './components/Register';

function App() {
  return (
    <BrowserRouter>
    <Header />
    <Container>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </Container>
    <Footer />
    </BrowserRouter>
  );
}

export default App;
