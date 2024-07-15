import styles from "./styles.module.css"
import { Link, useLocation, useNavigate } from "react-router-dom"
import loginLogo from "./../../assets/login.svg"

const Nav = ({ isAuth, logout }) => {
  const navigate = useNavigate()
  const location = useLocation()

  const handlelogin = () => {
    if (isAuth) {
      logout()
      navigate("/")
    } else {
      navigate("/login")
    }
  }

  return (
    <nav className={styles.nav}>
      <h1 onClick={() => navigate("/")}>Star Wars App</h1>

      {
        location.pathname !== "/" && (
          <>
            <Link to="/home" state="vehicles" className={styles.loginContainer}>
              <span>Vehicles</span>
            </Link>

            <Link to="/home" state="starships" className={styles.loginContainer}>
              <span>Starships</span>
            </Link>

            <Link to="/home" state="people" className={styles.loginContainer}>
              <span>People</span>
            </Link>

            <Link to="/home" state="films" className={styles.loginContainer}>
              <span>Films</span>
            </Link>
          </>

        )
      }


      <button onClick={handlelogin} className={styles.loginContainer}>
        <span>{isAuth ? "Log Out" : "Log In"}</span>
        <img src={loginLogo} />
      </button> 
    </nav>
  )
}

export default Nav