import React, { useState, useEffect } from 'react';
import AppBar from './components/AppBar';
import Sidebar from './components/Sidebar';
import ChatInterface from './components/ChatInterface';
import { ThemeProvider } from '@mui/material/styles';
import { lightTheme, darkTheme } from './theme';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; // Import routing components
import HomePage from './HomePage'; // Import the HomePage component
import ChatContainer from './ChatContainer';

function App() {
  const [theme, setTheme] = useState('dark');
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const [currentConversationId, setCurrentConversationId] = useState<number | null>(null);
  const [conversations, setConversations] = useState<Array<{ id: number, title: string, messages: Array<{ role: string, content: string }> }>>([]);
 

  const toggleTheme = () => {
    setTheme(theme === 'light' ? 'dark' : 'light');
  };
  const startNewConversation = () => {
    setCurrentConversationId(null);
};
useEffect(() => {
  const savedConversations = localStorage.getItem('conversations');
  if (savedConversations && conversations.length === 0) {
      console.log("Loading from local storage:", JSON.parse(savedConversations));
      setConversations(JSON.parse(savedConversations));
  } else {
      console.log("Not loading from local storage. Current conversations:", conversations);
  }
}, []);



useEffect(() => {
  if (conversations.length > 0) {
    console.log("Saving conversations to local storage:", conversations);
    localStorage.setItem('conversations', JSON.stringify(conversations));
  } else {
    console.log("Not saving empty conversations array to local storage.");
  }
}, [conversations]);



  useEffect(() => {
    if (currentConversationId !== null) {
      localStorage.setItem('currentConversationId', currentConversationId.toString());
    }
  }, [currentConversationId]);
  


  return (
    <ThemeProvider theme={theme === 'dark' ? darkTheme : lightTheme}>
   
    <AppBar toggleTheme={toggleTheme} theme={theme} />
     <Router>
      <Routes>
        <Route path="/"  element={<HomePage/>} /> {/* Render HomePage at the root route */}
        {/* Add other routes as needed */}
        <Route path="/higgsai-chat" element={<ChatContainer/>} /> {/* Example route */}
        {/* Add other components for the other routes */}
      </Routes>
    </Router>
  </ThemeProvider>
  );
}

export default App;
