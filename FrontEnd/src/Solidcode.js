import React, { useState,useEffect, } from "react"
import "bootstrap/dist/css/bootstrap.min.css"
import Navbar1 from "./components/Navbar1"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import "./Solidcode.css"
import {Search} from "./components/NewSearchBar"
import {Showplaylist} from "./components/Showplaylist"



function Musichome(){
    return(
    <>
    <Router>
    
        <Switch>
            <Route exact path="/">
            <Home />
            </Route>
            <Route path="/playlist" >
                <Playliste/>
            </Route>
            <Route path="/profile">
                <Profile/>
            </Route>
        </Switch>
    </Router>
    </>
    )}
    
    function Home() {
        return (
            <>
            <div className="home">
            <Navbar1/>
                <Search/>
            </div>
            </>
        )
    }

    function Playliste() {
        return (
            <div className="playliste">
                <Navbar1/>
                <h1>Playliste</h1>
                
            </div>
        )
    }


    function Profile() {
        return (
            <>
            <div className="profile">
            <Navbar1/>
                <h1>Profile</h1>
            </div>
            </>
        )
    }

   
    export default Musichome;