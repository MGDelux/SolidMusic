import React, { useState, useEffect } from "react"
import  "./fetchtable.css"
import addToPlayList from './playlist';



const Test = () => {

    const[items, Setitems] = useState([])
    const[searchterm, SetsearchTerm] = useState("Sia")


    

    useEffect(() => {  
          const search = async() => {
            const options = makeOptions("GET", true);
console.log("opts: "+options)
await fetch("http://localhost:8080/SolidCode-BackEnd/api/playlist/get",options)
.then(res => res.json())
.then((result)=> {
    Setitems(result)
     console.log(result)
  
}
)

}
if(searchterm){
    search()
}

},[searchterm])
const resultMap = items.map(item => {
return(
    <>
   
    <tr>  
    <td className="td_image">
      
      <img className="td_image" src = {item.header_image_thumbnail_url} ></img>
      <tr>
        <div className="trdiv">
         <div>
           <button><a href={'https://genius.com/'+item.url}>LYRICS</a></button> 
        </div>
        </div>
      </tr>
    </td>

  <td className="result_title"> {item.full_title} <tr className="result_artist">{item.artist.name}</tr>
  </td>
    <td className="result_artist"> {item.title_with_featured} 
   <div className="options_music">
       </div>
    </td>
    </tr>
    </>
)
})

return (

     <> 
       
 <h1>Din playlist: </h1>
      <br></br>

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

const getToken = () => {
    return localStorage.getItem('jwtToken')
  }
const makeOptions= (method,addToken) =>{
    var opts = {
      method: method,
      headers: {
        "Content-type": "application/json",
        'Accept': 'application/json',
      }
    }
    if (addToken) {
      opts.headers["x-access-token"] = getToken();
    }
    return opts;
  }

export  {Test}