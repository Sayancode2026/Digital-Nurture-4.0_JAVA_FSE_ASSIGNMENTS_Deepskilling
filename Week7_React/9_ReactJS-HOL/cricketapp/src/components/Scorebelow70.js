import React from 'react';

function Scorebelow70({ players }) {
  return (
    <div>
      {/* Filtering players and then mapping over the result */}
      {players
        .filter(player => player.score <= 70)
        .map((item) => (
          <div key={item.name}>
            <li>
              Mr. {item.name} <span>{item.score}</span>
            </li>
          </div>
        ))}
    </div>
  );
}

export default Scorebelow70;