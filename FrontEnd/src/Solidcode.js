import React, { useState,useEffect } from "react"
import "bootstrap/dist/css/bootstrap.min.css"
import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
import Navbar1 from "./components/Navbar1"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import "./Solidcode.css"
import Home from "./Pages/Home"
import Profile from "./Pages/Profile"
import Playliste from "./Pages/Playliste"


function Musichome(){
    return(
    <>
    <Router>
        <Navbar1/>
        <Switch>
            <Route path="/" exact components={Home}/>
            <Route path="/Profile" components={Profile}/>
            <Route path="/Playlist" components={Playliste}/>
        </Switch>
    </Router>
    </>
    )}
    
    export default Musichome;