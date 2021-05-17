import React, { useState, useEffect } from "react"

function Fetchplaylist(message) {
    const[items, Setitems] = useState([])
    const URL = "http://localhost:8080/SolidCode-BackEnd";
    const options = makeOptions("POST", true);

useEffect(() => {
    fetch(URL+"/api/playlist/get",options) 
    .then(res => res.json())
    .then((result) => {
    Setitems(result)
    console.log(result)
    }
    )
  })
  const resultMap = items.map(item =>{
    return(
    <>
    <tr>
        {items.result}
        

    </tr>
    
    </>
    )
      }
)

  const getToken = () => {
    return localStorage.getItem('jwtToken')
  }
  
  
  const makeOptions= (method,addToken,body) =>{
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
    if (body) {
      opts.body = JSON.stringify(body);
    }
    return opts;
  }
}
 
  
  
