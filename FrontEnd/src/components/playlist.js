<<<<<<< HEAD
function addToPlayList(message) {
    const token = localStorage.getItem('jwtToken')
    console.log("updated",message);
    console.log(token)
    const options = makeOptions("POST", true,{playlist: message });
    return fetch(URL+"/api/playlist/addsong",options) 
  }
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
  
  
  export default addToPlayList;
=======
const URL = "http://localhost:8080/SolidCode-BackEnd";

function addToPlayList(message) {
  const token = localStorage.getItem('jwtToken')
  console.log("updated",message);
  console.log(token)
  const options = makeOptions("POST", true,{playlist: message });
  return fetch(URL+"/api/playlist/addsong",options) 
}
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


export default addToPlayList;
>>>>>>> 10787fa6d39179612bcb145feeb3c4f0e1ea7c34
