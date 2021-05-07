import {button, Breadcrumb, Card, Form, Container, Row, Col,Table} from "react-bootstrap"
import React, { useState,useEffect } from "react"
import  "./fetchtable.css"
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";

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
            <td className="td_image">
              
              <img className="td_image" src = {item.result.header_image_thumbnail_url} ></img>
              <tr>
                <div className="trdiv">
                 <button>SPOTIFY BUTTON</button> 
                 <div>
                   <button><a href={'https://genius.com/'+item.result.url}>LYRICS</a></button> 
                </div>
                </div>
              </tr>
            </td>
          <td className="result_title"> {item.result.title} <tr className="result_artist">{item.result.primary_artist.name}</tr>
          </td>
            <td className="result_artist"> {item.result.title_with_featured} 
           <div className="options_music">*ADD TO PLAYLIST*</div>
            </td>
    
            </tr>
            
           </>
           )}
          </tbody>
          </Table>
          
          </div>
      );
      
    }
  }

  export {Fetchmusic}