import React from 'react';
import Card from './components/Card'; // Import the Card component
import { Grid, Container } from '@mui/material'; // Import Grid and Container from Material-UI for layout

const HomePage: React.FC = () => {
    const handleCardClick = (route: string) => {
      window.location.href = route; // Navigate to the respective route when a card is clicked
    };
  
    return (
      <div className="flex flex-col items-center justify-center min-h-screen">
        <div className="grid grid-cols-2 gap-4">
          <Card title="Higgsai Chat" onClick={() => handleCardClick('/higgsai-chat')} />
          <Card title="Prompt Studio" onClick={() => handleCardClick('/prompt-studio')} />
          <Card title="System Prompts" onClick={() => handleCardClick('/system-prompts')} />
          <Card title="User Management" onClick={() => handleCardClick('/user-management')} />
        </div>
      </div>
    );
  };

export default HomePage;
