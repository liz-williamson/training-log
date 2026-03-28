import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ThemeProvider, CssBaseline, Box } from '@mui/material';
import theme from './theme';
import Sidebar from './components/Sidebar';
import Dashboard from './components/Dashboard';
import LogEntryView from './components/LogEntryView';

function App() {
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Router>
                <Box sx={{ display: 'flex' }}>
                    <Sidebar />
                    <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
                        <Routes>
                            <Route path="/" element={<Dashboard/>}/>
                            <Route path="/calendar" element={<div>Calendar</div>} />
                            <Route path="/log/:id" element={<LogEntryView/>} />
                            <Route path="/log/new" element={<div>New Log Entry</div>} />
                            <Route path="/races" element={<div>Race History</div>} />
                        </Routes>
                    </Box>
                </Box>
            </Router>
        </ThemeProvider>
    );
}

export default App;
