import React, { useState, useEffect } from "react"
import axios from "axios"

const Search = () => {
  const [term, setTerm] = useState("")
  const [results, setResults] = useState([])

  useEffect(() => {
    const search = async () => {
      const { data } = await axios.get("https://en.wikipedia.org/w/api.php", {
        params: {
          action: "query",
          list: "search",
          origin: "*",
          format: "json",
          srsearch: term,
        },
      })
      setResults(data)
    }
    // quick check for term value so we don't request search of empty string
    if (term) {
      search()
    }
  }, [term])

  console.log(results)

  return (
    <div>
      <div className="ui form">
        <div className="field">
          <label>Search Term</label>
          <input
            className="input"
            value={term}
            onChange={e => setTerm(e.target.value)}
          />
        </div>
      </div>
    </div>
  )
}

export default Search

components/Search.js
import React, { useState, useEffect } from "react"
import axios from "axios"

const Search = () => {
  const [term, setTerm] = useState("React")
  const [results, setResults] = useState([])

  useEffect(() => {
    const search = async () => {
      const { data } = await axios.get("https://en.wikipedia.org/w/api.php", {
        params: {
          action: "query",
          list: "search",
          origin: "*",
          format: "json",
          srsearch: term,
        },
      })
      setResults(data)
    }
    search()
  }, [term])

  console.log(results)

  return (
    <div>
      <div className="ui form">
        <div className="field">
          <label>Search Term</label>
          <input
            className="input"
            value={term}
            onChange={e => setTerm(e.target.value)}
          />
        </div>
      </div>
    </div>
  )
}

export default Search