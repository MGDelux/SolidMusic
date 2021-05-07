import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
import React, { useState,useEffect } from "react"
import  "./fetchtable.css"


function Fetchmusic()   {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
 
    useEffect(() => {
      fetch("http://localhost:8080/SolidCode-BackEnd/api/solidMusic/search?q=Sia")
        .then(res => res.json())
        .then(
          (result) => {
        
            setItems(result);
         
              setIsLoaded(true);

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
     <div className="div-table">
        <Table >
        <thead>
          <tr>
          <th scope="col"></th>
             <th scope="col"></th>
             <th scope="col"></th>
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
          
          </div>
      );
      
    }
  }

  export {Fetchmusic}