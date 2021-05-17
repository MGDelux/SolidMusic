function addToPlayList(message) {
<<<<<<< HEAD
    const URL = "http://localhost:8080/SolidCode-BackEnd";
    const token = localStorage.getItem('jwtToken')
    console.log("updated",message);
    console.log(token)
    const options = makeOptions("POST", true,{playlist: message });
    return fetch(URL+"/api/playlist/addsong",options) 
=======
  const token = localStorage.getItem('jwtToken')
  console.log("updated",message);
  console.log(token)
  const options = makeOptions("POST", true,{SelectedSong: message });
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
>>>>>>> 2e7f99857bf868506bcfbaa69b720b33231a6712
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
