import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
import React, { useState,useEffect } from "react"


function Fetchmusic() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
 
    useEffect(() => {
      fetch("http://localhost:8080/SolidCode-BackEnd/api/solidMusic/search?q=jason derulo")
        .then(res => res.json())
        .then(
          (result) => {
            setIsLoaded(true);
            setItems(result.response.hits);
            console.log(result.response.hits);
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
        {items.response.hits.map(item =>
            <>
          <tr>
          <td>
          {item.result.title}</td>
            <td> {item.result.primary_artist.name} </td>
            <td>hello</td>
            <td></td>
            </tr>
           </>
           )}
          ))
          </tbody>
          </Table>
          </container>
      );
    }
  }

  export {Fetchmusic}