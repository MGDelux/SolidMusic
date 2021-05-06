function fetchmusic() {
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