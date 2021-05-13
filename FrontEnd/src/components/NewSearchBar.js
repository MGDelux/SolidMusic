import React, { useState, useEffect } from "react"
import facade from "../apiFacade"
import  "./fetchtable.css"
<<<<<<< HEAD
import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
import log from './playlist';
=======

>>>>>>> 046238bf06d6f6ee85faeaabd4c724018fd2fab9

const Search = () => {
    const[searchterm, SetsearchTerm] = useState("Sia")
    const[items, Setitems] = useState([])


    useEffect(() => {
     const timer = setTimeout(() => {
        const search = async() => {
await fetch("https://solidcode.xyz/SolidMusic/api/solidMusic/search?q="+searchterm)
.then(res => res.json())
.then((result)=> {
    Setitems(result.response.hits)
  
}
)

}
if(searchterm){
    search()
}
},400);
return() =>clearTimeout(timer);
},[searchterm])

const resultMap = items.map(item =>{
    return (
    
        <tr>  
        <td className="td_image">
          
          <img className="td_image" src = {item.result.header_image_thumbnail_url} ></img>
          <tr>
            <div className="trdiv">
             <button>SPOTIFY BUTTON</button> 
             <div>
               <button><a href={'https://genius.com/'+item.result.url}>LYRICS</a></button> 
            </div>
            </div>
          </tr>
        </td>
      <td className="result_title"> {item.result.title} <tr className="result_artist">{item.result.primary_artist.name}</tr>
      </td>
        <td className="result_artist"> {item.result.title_with_featured} 
<<<<<<< HEAD
       <button onClick={log.bind(this,item)}>smilebois</button>
=======
       <div className="options_music">
           <button onClick={facade.playlist}>*ADD TO PLAYLIST*</button></div>
>>>>>>> 046238bf06d6f6ee85faeaabd4c724018fd2fab9
        </td>

        </tr>
    )
})
return (

     <> 
        <div className="searchbar">
          <label className="searchbar">Search Music:</label>
          <input
            className="search_input"
            value={searchterm}
            onChange={e => SetsearchTerm(e.target.value)}
          />
          <a href="#" className="search_icon"><i className="fas fa-search"></i></a>
        </div>
      
     
      <div className="div-table">
          <thead>
          <tr>
          <th scope="col"></th>
             <th scope="col"></th>
             <th scope="col"></th>
        </tr>
        </thead>

          {resultMap}
          
      </div>
    </>
)
}


const playlist = () => {

const [token, setToken] = usestate("");
const [data, setData] = usestate({});


useEffect(() => {
if(localStorage.getItem("jwtToken")){
    setToken(localStorage.getItem("jwtToken"))
}

}, [])

}


export {Search}