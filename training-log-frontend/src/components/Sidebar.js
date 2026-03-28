import { Drawer, List, ListItem, ListItemIcon, ListItemText } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import DashboardIcon from '@mui/icons-material/Dashboard';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import EmojiEventsIcon from '@mui/icons-material/EmojiEvents';

const DRAWER_WIDTH = 220;

const navItems = [
    { label: 'Dashboard', icon: <DashboardIcon />, path: '/' },
    { label: 'New Log Entry', icon: <AddCircleIcon />, path: '/log/new' },
    { label: 'Calendar', icon: <CalendarMonthIcon />, path: '/calendar' },
    { label: 'Race History', icon: <EmojiEventsIcon />, path: '/races' },
];

function Sidebar() {
    const navigate = useNavigate();

    return (
        <Drawer
            variant="permanent"
            sx={{
                width: DRAWER_WIDTH,
                '& .MuiDrawer-paper': {
                    width: DRAWER_WIDTH,
                    backgroundColor: 'background.paper',
                    borderRight: '1px solid #333',
                },
            }}
        >
            <List sx={{ mt: 2 }}>
                {navItems.map(item => (
                    <ListItem
                        button
                        key={item.label}
                        onClick={() => navigate(item.path)}
                        sx={{
                            '&:hover': { color: 'primary.main' },
                            borderRadius: 1,
                            mx: 1,
                        }}
                    >
                        <ListItemIcon sx={{ color: 'primary.main' }}>
                            {item.icon}
                        </ListItemIcon>
                        <ListItemText primary={item.label} />
                    </ListItem>
                ))}
            </List>
        </Drawer>
    );
}

export default Sidebar;
