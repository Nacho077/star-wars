import { Link } from "react-router-dom";

import darthVader from "./../../assets/darthVader.jpg"
import styles from "./styles.module.css"

const elements = ["Vehicles", "Starships", "People", "Films"]

const Landing = ({isAuth}) => {
  return (
    <>
      <main className={styles.main}>
        <aside className={styles.leftSection}>
          <img src={darthVader} />
        </aside>

        <section className={styles.rightSection}>
          {elements.map((element) => (
            <Link key={element} to={!isAuth ? "/login" : "/home"} state={element.toLowerCase()} className={styles.link}>
              {element}
            </Link>
          ))}
        </section>
      </main >
    </>
  )
}

export default Landing