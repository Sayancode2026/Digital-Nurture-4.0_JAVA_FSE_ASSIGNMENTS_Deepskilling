import React from 'react';
import './App.css';

// Import all the components we created
import UserGreeting from './components/UserGreeting';
import GuestGreeting from './components/GuestGreeting';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';

class App extends React.Component {
  constructor(props) {
    super(props);
    // Initialize state. isLoggedIn determines what the user sees.
    this.state = { isLoggedIn: false };

    // Bind the event handlers to this component instance
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
  }

  // This function is called when the Login button is clicked
  handleLoginClick() {
    this.setState({ isLoggedIn: true });
  }

  // This function is called when the Logout button is clicked
  handleLogoutClick() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    // Get the current login state
    const isLoggedIn = this.state.isLoggedIn;
    
    // This is an "element variable". It will hold the button component.
    let button;
    let greeting;

    // Conditional rendering: if the user is logged in...
    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />;
      greeting = <UserGreeting />;
    } else {
      // ...otherwise (if the user is logged out)
      button = <LoginButton onClick={this.handleLoginClick} />;
      greeting = <GuestGreeting />;
    }

    return (
      <div className="App">
        {/* Render the greeting and the button we determined above */}
        {greeting}
        {button}
      </div>
    );
  }
}

export default App;