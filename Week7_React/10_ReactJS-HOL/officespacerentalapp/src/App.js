import React from 'react';
import './App.css';

function App() {
  // Create a list of office space objects
  const officeList = [
    {
      id: 1,
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      Image: "https://images.unsplash.com/photo-1521737604893-d14cc237f11d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8b2ZmaWNlJTIwYnVpbGRpbmd8ZW58MHx8MHx8fDA%3D"
    },
    {
      id: 2,
      Name: "WeWork",
      Rent: 75000,
      Address: "Mumbai",
      // --- NEW WEWORK IMAGE LINK ---
      Image: "https://images.unsplash.com/photo-1522202176988-66273c2fd55f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8d2V3b3JrfGVufDB8fDB8fHww"
    },
    {
      id: 3,
      Name: "Regus",
      Rent: 58000,
      Address: "Bengaluru",
      // --- NEW REGUS IMAGE LINK ---
      Image: "https://images.unsplash.com/photo-1541746972996-4e0b0f43e02a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fG1lZXRpbmclMjByb29tfGVufDB8fDB8fHww"
    }
  ];

  return (
    <div className="App">
      <h1>Office Spaces, at Affordable Range</h1>
      <hr />
      
      {/* Loop through the office list using map() */}
      {officeList.map((office) => {
        // Apply conditional style for each item in the list
        const rentStyle = {
          color: office.Rent <= 60000 ? 'red' : 'green'
        };

        return (
          // The key attribute is crucial for lists in React
          <div key={office.id}>
            <img src={office.Image} width="25%" height="25%" alt={office.Name}/>
            <h1>Name: {office.Name}</h1>
            <h3 style={rentStyle}>Rent: Rs. {office.Rent}</h3>
            <h3>Address: {office.Address}</h3>
            <hr />
          </div>
        );
      })}
    </div>
  );
}

export default App;