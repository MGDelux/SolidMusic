import React, { useState, useEffect } from "react"
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import {Link} from "react-router-dom";
import {SidebarData} from "./SidebarData";
import "./Navbar.css"
import {IconContext} from "react-icons"


function Navbar1() {
    const [sidebar, setsidebar] = useState(false)
    
    const showSidebar = () => setsidebar(!sidebar)
    

    return (
        <>
        <IconContext.Provider value={{color: "orange"}}>
            <div className="navbar">
                <Link to="#" className="menu-bars">
                    <FaIcons.FaBars onClick={showSidebar}/>
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
            </IconContext.Provider>
        </>
    );
}



export default Navbar1;
