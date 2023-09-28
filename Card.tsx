import React from 'react';

interface CardProps {
  title: string;
  onClick: () => void;
}

const Card: React.FC<CardProps> = ({ title, onClick }) => {
  return (
    <div 
      onClick={onClick} 
      className="cursor-pointer w-60 h-40 bg-gray-200 rounded-lg flex items-center justify-center text-sm"
    >
      <p className="text-center">{title}</p>
    </div>
  );
};

export default Card;
