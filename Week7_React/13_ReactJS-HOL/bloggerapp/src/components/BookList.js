import React from 'react';

function BookList({ books }) {
  return (
    <div>
      <h2>Book Details</h2>
      {books.map((book) => (
        // The 'key' prop is essential for lists
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <p>{book.price}</p>
        </div>
      ))}
    </div>
  );
}

export default BookList;