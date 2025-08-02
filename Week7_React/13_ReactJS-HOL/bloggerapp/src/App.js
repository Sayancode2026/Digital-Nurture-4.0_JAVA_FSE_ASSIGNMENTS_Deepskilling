import React, { useState } from 'react';
import './App.css';

// Import data and components
import { books, courses, blogs } from './data.js';
import BookList from './components/BookList';
import CourseList from './components/CourseList';
import BlogList from './components/BlogList';

function App() {
  // useState hook to manage which view is active
  const [view, setView] = useState('all'); // 'all', 'books', 'courses', 'blogs'

  return (
    <div>
      <div style={{ padding: '10px', textAlign: 'center' }}>
        <h2>Dashboard</h2>
        <p>Select a view:</p>
        <button onClick={() => setView('all')}>Show All</button>
        <button onClick={() => setView('books')}>Books Only</button>
        <button onClick={() => setView('courses')}>Courses Only</button>
        <button onClick={() => setView('blogs')}>Blogs Only</button>
      </div>

      <div className="app-container">
        {/* Method 1: Logical && Operator */}
        {/* This is a concise way to render a component only if a condition is true. */}
        
        { (view === 'all' || view === 'courses') && <CourseList courses={courses} /> }
        { (view === 'all' || view === 'books') && <BookList books={books} /> }
        { (view === 'all' || view === 'blogs') && <BlogList blogs={blogs} /> }

        {/* Method 2: Ternary Operator (Example) */}
        {/* Useful for simple if-else logic. Here, it shows a message if a specific view is selected. */}
        { view !== 'all' ? <p style={{color: 'blue', width: '100%', textAlign: 'center'}}>Displaying selected view only.</p> : null }
      </div>
    </div>
  );
}

export default App;