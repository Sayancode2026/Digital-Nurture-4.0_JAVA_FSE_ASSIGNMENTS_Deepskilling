import React from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor'; // Import the component

class App extends React.Component {
  constructor(props) {
    super(props);
    // Initialize state with a starting count of 5
    this.state = { count: 5 };

    // Binding is necessary to make `this` work in the callback
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  // This method will call multiple other methods
  increment() {
    this.incrementCounter();
    this.sayHello();
  }
  
  incrementCounter() {
    this.setState({ count: this.state.count + 1 });
  }
  
  sayHello() {
      alert('Hello! Member1');
  }

  decrement() {
    this.setState({ count: this.state.count - 1 });
  }

  // This handler accepts an argument
  sayWelcome(message) {
    alert(message);
  }

  // This handler demonstrates a simple click event
  handleClick() {
    alert('I was clicked');
  }

  render() {
    return (
      <div className="App">
        <h1>{this.state.count}</h1>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        
        {/* Use an arrow function to pass an argument to the event handler */}
        <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>
        
        <button onClick={this.handleClick}>Click on me</button>
        
        <hr />
        
        {/* Render the CurrencyConvertor component */}
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;