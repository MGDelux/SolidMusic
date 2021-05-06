import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
import React, { useState,useEffect } from "react"
import Navbar1 from "./components/Navbar1"

function Fetchmusic() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
 
    useEffect(() => {
      fetch("http://localhost:8080/SolidCode-BackEnd/api/solidMusic/search"+{value})
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
             <th scope="col">Title name</th>
             <th scope="col">Artist</th>
        </tr>
        </thead>
        <tbody>
          {items.map(item => (
            <>
          <tr >  
            <td key={item.name}>
            {item.name}
            </td>
            <td>{item.name}</td>
            <td></td>
            <td></td>
            </tr>
           </>
          ))}
          </tbody>
          </Table>
          </container>
      );
    }
  }

  export {Fetchmusic}