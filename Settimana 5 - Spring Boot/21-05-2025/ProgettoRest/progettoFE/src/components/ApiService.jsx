import React, { useState, useEffect } from "react";
import axios from 'axios';

const ApiService = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState([true]);
    const [error, setError] = useState([null]);
    const [postData, setPostData] = useState({title: '', body: ''});

    //GET request (fetch dei dati)
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/oggetti');
                setData(response.data);
            } catch (error) {
                setError(error.message);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, []);

    // POST Request (invia dati)
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        'http://localhost:8080/oggetti',
        postData
      );
      console.log("Dati inviati:", response.data);
      // Aggiorna lo stato con la nuova risposta
      setData([...data, response.data]);
    } catch (err) {
      setError(err.message);
    }
  };
}