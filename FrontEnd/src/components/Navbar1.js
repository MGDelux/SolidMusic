import React, { useState,useEffect } from "react"
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import {Link} from "react-router-dom";
import {SidebarData} from "./SidebarData";
import "./Navbar.css"
import {IconContext} from "react-icons"
import {Fetchmusic} from "../Fetch";

function Navbar1() {
    const [sidebar, setsidebar] = useState(false)
    
    const showSidebar = () => setsidebar(!sidebar)
    
    const [Search, setSearch] = useState('')

    return (
        <>
        <IconContext.Provider value={{color: "orange"}}>
            <div className="navbar">
                <Link to="#" className="menu-bars">
                    <FaIcons.FaBars onClick={showSidebar}/>
                </Link>
                <Link>
            <div class="searchbar">
          <input class="search_input" type="text" name="Searching" placeholder="Search..." onChange={event => setSearch(event.target.value)}/>
          <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
             </div>
             </Link>
             <Link className="nav-logout">
             <FaIcons.FaKey />
             </Link>
            </div>
           

            <nav className={sidebar ? "nav-menu active" : "nav-menu"}>
                <ul className="nav-menu-items" onClick={showSidebar}> 
                    <li className="navbar-toggle">
                        <Link to="#" className="menu-bars">
                            <AiIcons.AiOutlineClose/>
                        </Link>
                    </li>
                    {SidebarData.map((item, index) => {
                        return(
                            <li key={index} className={item.cName}>
                                <Link to={item.path}>
                                    {item.icon}
                                    <span>{item.title}</span>
                                </Link>
                            </li>
                        )
                    })}
                </ul>
            </nav>
            <body>
                <h1>Smid en fetch metode med en tabel her.</h1>
               
                 <Fetchmusic/> 
   
            </body>
            </IconContext.Provider>
        </>
    );
}



export default Navbar1;
