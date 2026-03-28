import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import api from '../api.js';

function LogEntryView() {
    const [entry, setEntry] = useState()
    const {id} = useParams();

    useEffect(() => {
        api.get(`/log-entries/${id}`)
        .then(res => setEntry(res.data))
        .catch(err => console.log(err))
    }, [id])

    if (!entry) return <p>Loading...</p>;

    return (
        <div>
            <h1> Log Entry {entry.id}</h1>
            <li> Date: {entry.date} </li>
            {entry.isRaceDay ? <li> Race Day - Meet Name: {entry.meetName} </li> : ""}
            <li> Notes: {entry.notes} </li>
        </div>
    )
}
export default LogEntryView;
