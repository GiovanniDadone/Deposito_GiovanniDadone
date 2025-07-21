// components/OggettiService.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const OggettiService = () => {
  const [oggetti, setOggetti] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [newOggetto, setNewOggetto] = useState({ numero: '' });

  // GET - Recupera tutti gli oggetti
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('api/oggetti');
        setOggetti(response.data);
      } catch (err) {
        setError(`Errore durante il caricamento: ${err.message}`);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, []);

  // POST - Aggiunge un nuovo oggetto
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        'api/oggetti',
        { numero: newOggetto.numero },
        {
          headers: {
            "Content-Type": 'application/json'
          }
        }
      );
      setOggetti([...oggetti, response.data]);
      setNewOggetto({ numero: '' });
    } catch (err) {
      setError(`Errore durante l'invio: ${err.response?.data || err.message}`);
    }
  };

  // DELETE - Elimina un oggetto
  const handleDelete = async (id) => {
    try {
      await axios.delete(`api/oggetti/${id}`);
      setOggetti(oggetti.filter(oggetto => oggetto.id !== id));
    } catch (err) {
      setError(`Errore durante l'eliminazione: ${err.message}`);
    }
  };

  if (loading) return <div className="loading">Caricamento in corso...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div className="oggetti-container">
      <h2>Gestione Oggetti</h2>

      {/* Form per aggiunta */}
      <form onSubmit={handleSubmit} className="oggetti-form">
        <input
          type="number"
          name="numero"
          placeholder="Inserisci numero"
          value={newOggetto.numero}
          onChange={(e) => setNewOggetto({ numero: e.target.value })}
          required
        />
        <button type="submit">Aggiungi</button>
      </form>

      {/* Lista oggetti */}
      <table className="oggetti-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Numero</th>
            <th>Azioni</th>
          </tr>
        </thead>
        <tbody>
          {oggetti.map((oggetto) => (
            <tr key={oggetto.id}>
              <td>{oggetto.id}</td>
              <td>{oggetto.numero}</td>
              <td>
                <button
                  onClick={() => handleDelete(oggetto.id)}
                  className="delete-btn"
                >
                  Elimina
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default OggettiService;