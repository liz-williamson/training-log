import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../api.js';

function Dashboard(){
    const [logs, setLogs] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        api.get('/log-entries')
        .then(res => setLogs(res.data))
        .catch(err => console.log(err))
    }, [])

    return (
        <div>
            <h1>Dashboard</h1>
            <ul>
                {logs.map(log => (
                    <li key = {log.id}>
                        {log.notes} - Date = {log.date}  <br />
                        <button onClick={() => navigate(`/log/${log.id}`)}> View Log </button>
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default Dashboard;
