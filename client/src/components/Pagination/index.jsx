import prev from "./../../assets/prev.svg"
import next from "./../../assets/next.svg"

import styles from "./styles.module.css"

const Pagination = ({ page, totalPages, handlePrev, handleNext }) => {
    return (
        <section className={styles.paginate}>
            <button onClick={handlePrev} disabled={page == 1}>
                <img src={prev} />
            </button>

            <span>Page {page}</span>

            <button onClick={handleNext} disabled={page == totalPages} >
                <img src={next} />
            </button>
        </section>
    )
}

export default Pagination