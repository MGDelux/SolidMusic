import React, { useState, useEffect } from "react"
import  "./fetchtable.css"
import addToPlayList from './playlist';
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"



toast.configure()

const Search = () => {
    const[searchterm, SetsearchTerm] = useState("Overkill")
    const[items, Setitems] = useState([])
    
    const notify = () => {
      toast.dark("Song added succesfully",{autoClose: 3000})
    }


    useEffect(() => {    const search = async() => {
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

},[searchterm])
const resultMap = items.map(item =>{
    return (
      
      <>
  
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
       <div className="options_music">
<<<<<<< HEAD
       <button className="addToPlaylistButton" onClick={addToPlayList.bind(this,item)}>Add: '{item.result.title}' to your playlist </button>


=======
       <button className="addToPlaylistButton" onClick={addToPlayList.bind(this,item), notify}>Add: '{item.result.title}' to your playlist </button>
>>>>>>> ce024666ca0f0efe163b27ab435a5f4579cede1f
           </div>
        </td>
        
        </tr>
        
        </>
    )
})
return (

     <> 
     <br></br>
        <div className="searchbar">
          <label className="searchbar1">Search:</label>
          <input
            className="search_input"
            value={searchterm}
            onChange={e => SetsearchTerm(e.target.value)}
          />
        </div>

      <br></br>

      <div className="div-table">
          <thead>
          <tr>
          <th scope="col"></th>
             <th scope="col"></th>
             <th scope="col"></th>
        </tr>
        </thead>
        <hr></hr>
          {resultMap}
          <hr></hr>
      </div>
   </>
)
}

export {Search}