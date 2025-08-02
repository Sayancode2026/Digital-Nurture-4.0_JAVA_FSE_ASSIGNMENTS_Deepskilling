import React from 'react';
import './App.css';

// Importing components for the flag=true view
import ListofPlayers from './components/ListofPlayers';
import Scorebelow70 from './components/Scorebelow70';

// Importing components and data for the flag=false view
import { OddPlayers } from './components/OddPlayers';
import { EvenPlayers } from './components/EvenPlayers';
import { ListofIndianPlayers } from './components/ListofIndianPlayers';
import { IndianPlayers, IndianTeamData } from './components/PlayersData';

function App() {
  // 🚩 Change this flag to true to see the other view
  const flag = false;

  // Data for the flag=true view
  const playersData = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 },
  ];

  if (flag) {
    return (
      <div className="App">
        <h1>List of Players</h1>
        <ListofPlayers players={playersData} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={playersData} />
      </div>
    );
  } else {
    return (
      <div className="App">
        <h1>Odd Players</h1>
        {OddPlayers(IndianTeamData)}
        <hr />
        <h1>Even Players</h1>
        {EvenPlayers(IndianTeamData)}
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;