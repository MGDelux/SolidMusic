import React, { useState,useEffect, Component } from "react"
import facade from "./apiFacade";
import Musichome from './Solidcode';
import {Card, Form, Container} from "react-bootstrap"
import "./App.css";

function LogIn({ login }) {
  const init = { username: "", password: "" };
  const [loginCredentials, setLoginCredentials] = useState(init);
 
  const performLogin = (evt) => {
    console.log("log in")
    evt.preventDefault();
    login(loginCredentials.username, loginCredentials.password);
  }
  const onChange = (evt) => {
    setLoginCredentials({ ...loginCredentials,[evt.target.id]: evt.target.value })
  }
 
  return (
  <Container >
    <div id="mydiv" className= "w-responsive text-center mx-auto p-3 mt-2">
     <Card className="mb-3">
       <Card.Img width="70%" src=""/>
       <Card.Body>
      <form className="login-form" onChange={onChange}>
        <Card.Title>
                <h2>SolidMusic</h2>
        </Card.Title>
        <Card.Text>
        Log in for some awesome music
      </Card.Text>
                <div className="form-group">
                
                    <label>Username</label>
                    <input id="username" className="form-control" placeholder="User Name" />
                

                
                    <label>Password</label>
                    <input id="password" type="password" className="form-control" placeholder="Password" />
                    
                </div>
                
                <button onClick={performLogin} className="btn btn-primary btn-block">Submit</button>
      </form>
      
      </Card.Body>
      </Card>
      </div>
    </Container>
  )
 
}
function LoggedIn() {
  const [dataFromServer, setDataFromServer] = useState("Loading...")
  useEffect(
    () => {
    facade.fetchData().then(data=> setDataFromServer(data.msg));
  },
   [])
 
  return (
    <>
    <Musichome/>
</>
  )
 
}

function App() {
  const [loggedIn, setLoggedIn] = useState(false)
 
  const logout = () => { 
  facade.logout()
  setLoggedIn(false)
} 
  const login = (user, pass) => 
  {
    facade.login(user,pass)
    .then(res =>setLoggedIn(true));
   } 
 
  return (
    <div>
      {!loggedIn ? (<LogIn login={login} />) :
        (<div>
          <button onClick={logout}>Logout</button>
          <LoggedIn />
          
        </div>)}
    </div>
  )
 
 
}
export default App;
 
