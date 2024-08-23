import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route, useNavigate  } from 'react-router-dom';
import Register from './Register';
import Login from './Login'; // Załóżmy, że masz komponent Login

function Home() {
    const navigate = useNavigate(); // Hook do nawigacji

    return (
        <div>
            <h1>Welcome to Our App</h1>
            <button onClick={() => navigate('/register')}>Go to Register</button>
            <button onClick={() => navigate('/login')}>Go to Login</button>
        </div>
    )
}

function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/" element={<Home />} />
					<Route path="/register" element={<Register />} />
					<Route path="/login" element={<Login />} />
                    {/* Dodaj inne trasy według potrzeb */}
                </Routes>
            </div>
        </Router>
    );
}

export default App;
