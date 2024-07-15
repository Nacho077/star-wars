import { useLocation } from "react-router";
import { useEffect, useState } from "react";
import axios from "axios";

import styles from "./styles.module.css"
import Card from "./../../components/Card"
import Pagination from "../../components/Pagination";

const Home = () => {
  const location = useLocation()
  const [items, setItems] = useState([])
  const [page, setPage] = useState(1)
  const [areActiveFilters, setAreActiveFilters] = useState(false)
  const [searchForm, setSearchForm] = useState({
    byName: "",
    byId: 0
  })
  const [isLoading, setLoading] = useState(true)
  const [totalPages, setTotalPages] = useState(1)

  const onChange = (e) => {
    const { name, value } = e.target

    setSearchForm((prevState) => ({
      ...prevState,
      [name]: value
    }))
  }

  const doSearch = url => {
    setLoading(true)
    axios.get(url)
    .then(({data}) => {
      setItems(data["results"])
      setTotalPages(data["total_pages"])
      setLoading(false)
    })
    
  }

  const handleSearch = async () => {
    let url = "/star-wars/" + location.state

    if (searchForm.byId) {
      url += `?id=${searchForm.byId}`
    } else {
      url += `?name=${searchForm.byName}`
    }

    doSearch(url)
    setAreActiveFilters(true)
  }

    const deleteAllFilters = () => {
      setPage(1)
      doSearch(`/star-wars/${location.state}?page=1`)
      setAreActiveFilters(false)
      setSearchForm({ byName: "", byId: "" })
    }

    const handlePrev = () => {
      setPage((prevState) => prevState - 1)
    }

    const handleNext = () => {
      setPage((prevState) => prevState + 1)
    }

    useEffect(() => {
      setPage(1)
      setSearchForm({ byName: "", byId: "" })
      doSearch(`/star-wars/${location.state}?page=1`)
    }, [location.state])

    useEffect(() => {
      doSearch(`/star-wars/${location.state}?page=${page}`)
    }, [page])

    const buttons = [
      {type: "number", name: "byId", max: 10000000, min: 1, placeholder: "e.g.: 1", label: "Search by id"},
      {type: "text", name: "byName", maxLength: 100, placeholder: "e.g.: Luke", label: "Search by name"}
    ]

    return (
      <main className={styles.homeContainer}>
        
      {isLoading ? <span className={styles.loader} /> : 
      <>
        <section className={styles.searchsContainer}>
            {buttons.map((button) => (
                <div className={styles.inputs}>
                    <label htmlFor={button.name}>{button.label}</label>
                    <input
                        type={button.type}
                        value={searchForm[button.name]}
                        onChange={onChange}
                        name={button.name}
                        placeholder={button.placeholder}
                    />
                </div>
            ))}
            <button onClick={handleSearch} disabled={!searchForm.byId && !searchForm.byName}>Search</button>
            <button onClick={deleteAllFilters} disabled={!areActiveFilters}>Delete all filters</button>
        </section>

        <section className={styles.cardsContainer}>
            {items?.map((item) => <Card item={item.name ? item : item.properties} key={item.name || item.properties.title} />)}
        </section>
        {totalPages && <Pagination page={page} totalPages={totalPages} handlePrev={handlePrev} handleNext={handleNext} />}</>}
      </main>
    )
}

export default Home;