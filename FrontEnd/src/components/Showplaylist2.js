

const Search = () => {
    const[searchterm, SetsearchTerm] = useState("Sia")
    const[items, Setitems] = useState([])


    useEffect(() => {
        const search = async() => {
            const options
await fetch("http://localhost:8080/SolidCode-BackEnd/api/playlist/get",Options
.then(res => res.json())
.then((result)=> {
    Setitems(result.response.hits)
  
}
)
}
if(searchterm){
    search()
}

},[searchterm])