import React from 'react';

function ListofPlayers({ players }) {
  return (
    <div>
      {/* Mapping over the players array to display each player */}
      {players.map((item) => (
        <div key={item.name}>
          <li>
            Mr. {item.name} <span>{item.score}</span>
          </li>
        </div>
      ))}
    </div>
  );
}

export default ListofPlayers;