import React, { useState, useEffect } from "react"

const Search = () => {
    const[searchterm, SetsearchTerm] = useState("React")
    const[items, Setitems] = useState([])
    const [isLoaded, setIsLoaded] = useState(false);


    useEffect(() => {
        const search = async() => {
fetch("http://localhost:8080/SolidCode-BackEnd/api/solidMusic/search?q="+searchterm)
.then(res => res.json())
.then((result)=> {
    Setitems(result)
    console.log(items)
    console.log(items.response)
    console.log(items.response.hits)
    setIsLoaded(true);
    
}
)

}
if(searchterm){
    search()
}

},[searchterm])
const resultMap = items.response.hits.map(item =>{
    return (
        <div>
            <p>{item.result.title}</p>
        </div>
    )
})
console.log(items)
return (
<div>
      <div className="ui form">
        <div className="field">
          <label>Search Term</label>
          <input
            className="input"
            value={searchterm}
            onChange={e => SetsearchTerm(e.target.value)}
          />
        </div>
      </div>
      <div>
          {resultMap}
      </div>
    </div>
)
}

export {Search}