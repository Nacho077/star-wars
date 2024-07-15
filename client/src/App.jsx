import { useState } from 'react'
import { Route, Routes, useLocation } from 'react-router'
import './App.css'
import Login from './views/Login'
import Register from './views/Register'
import Landing from './views/Landing'
import Home from './views/Home'
import Nav from './components/Nav'
import { apiLogout } from './configurations/axios'

const App = () => {
  const location = useLocation()

  const [isAuth, setIsAuth] = useState(false)

  const login = () => {
    setIsAuth(true)
  }

  const logout = () => {
    apiLogout()
    setIsAuth(false)
  }

  return (
    <>
      {location.pathname != "/login" && location.pathname != "/register" && <Nav isAuth={isAuth} logout={logout} />}

      <Routes>
        <Route path='/' element={<Landing isAuth={isAuth} />} />
        <Route path='/login' element={<Login login={login} />} />
        <Route path='/register' element={<Register login={login} />} />
        <Route path='/home' element={<Home />} />
      </Routes>
    </>
  )
}

export default App
