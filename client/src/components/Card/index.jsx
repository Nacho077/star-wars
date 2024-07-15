import styles from "./styles.module.css"

const Card = ({ item }) => {
    return (
        <div className={styles.card}>
            {item.title && <h2>{item.title}</h2>}
            {item.name && <h2>{item.name}</h2>}

            {item.director && <p>Director: {item.director}</p>}
            {item.producer && <p>Producer: {item.producer}</p>}
            {item.opening_crawl && <p>{item.opening_crawl}</p>}

            {item.height && <p>Height: {item.height}</p>}
            {item.mass && <p>Mass: {item.mass}</p>}
            {item.hair_color && <p>Hair color: {item.hair_color}</p>}
            {item.eye_color && <p>Eye color: {item.eye_color}</p>}
            {item.birth_year && <p>Birth year: {item.birth_year}</p>}
            {item.gender && <p>Gender: {item.gender}</p>}
        </div>
    )
}

export default Card;