import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    // Initialize state to hold form input values
    this.state = { amount: '', currency: '' };

    // Bind event handlers to 'this' instance
    this.handleAmountChange = this.handleAmountChange.bind(this);
    this.handleCurrencyChange = this.handleCurrencyChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  // Update state when amount input changes
  handleAmountChange(event) {
    this.setState({ amount: event.target.value });
  }

  // Update state when currency input changes
  handleCurrencyChange(event) {
    this.setState({ currency: event.target.value });
  }

  // Handle the form submission
  handleSubmit(event) {
    // Prevent the default browser page reload
    event.preventDefault(); 
    
    const amount = this.state.amount;
    const currency = this.state.currency;

    if (currency.toLowerCase() === 'euro') {
      // Assuming a fixed conversion rate for demonstration, e.g., 1 INR = 80 Euro (as implied by screenshot)
      const convertedAmount = amount * 80; 
      alert(`Converting to Euro Amount is ${convertedAmount}`);
    } else {
      alert(`Currency conversion for ${currency} is not supported.`);
    }
  }

  render() {
    return (
      <div>
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Amount:
            <input type="text" value={this.state.amount} onChange={this.handleAmountChange} />
          </label>
          <br /><br />
          <label>
            Currency:
            <input type="text" value={this.state.currency} onChange={this.handleCurrencyChange} />
          </label>
          <br /><br />
          <input type="submit" value="Submit" />
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;