import React, { useState,useEffect } from "react"
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";
import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
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
                <Link>
            <div class="searchbar">
          <input class="search_input" type="text" name="Search" placeholder="Search..."/>
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

            </body>
            </IconContext.Provider>
        </>
    );
}



/*function fetchmusic() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
 
    useEffect(() => {
      fetch("http://localhost:8080/SolidCode-BackEnd/api/dummyAPI/all")
        .then(res => res.json())
        .then(
          (result) => {
            setIsLoaded(true);
            setItems(result);
            console.log(result);
          },
          (error) => {
            setIsLoaded(true);
            setError(error);
          }
        )
    }, [])
  
    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      return <div>Loading...</div>;
    } else {
      return (
        <container className="themed-container" fluid="md">
        <Table striped bordered hover variant="dark" responsive>
        <thead>
          <tr>
          <th scope="col">#ID</th>
             <th scope="col">Name</th>
             <th scope="col">Day</th>
             <th scope="col">Time</th>
        </tr>
        </thead>
        <tbody>
          {items.map(item => (
            <>
          <tr >  
            <td key={item.id}>
            {item.id}
            </td>
            <td>{item.name}</td>
            <td>{item.date.date.year}/{item.date.date.month}/{item.date.date.day}  </td>
            <td>{item.date.time.hour}:{item.date.time.minute}:{item.date.time.second}</td>
            </tr>
           </>
          ))}
          </tbody>
          </Table>
          </container>
      );
    }
  }
*/

export default Navbar1;
