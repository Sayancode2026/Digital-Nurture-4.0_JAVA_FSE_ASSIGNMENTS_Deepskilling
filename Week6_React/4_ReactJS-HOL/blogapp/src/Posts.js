import React from 'react';
import Post from './Post';

class Posts extends React.Component {

    // 1. Initialize state in the constructor
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    // 2. This method is called by React after the component is rendered for the first time
    componentDidMount() {
        this.loadPosts();
    }

    // 3. This method fetches data from the API and updates the state
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                // Map the raw data to our Post class instances
                const posts = data.map(p => new Post(p.id, p.title, p.body));
                this.setState({ posts: posts });
            })
            .catch(error => {
                console.error("Error fetching posts: ", error);
                this.setState({ hasError: true });
            });
    }

    // 4. This lifecycle method catches errors in child components
    componentDidCatch(error, info) {
        alert('An error occurred: ' + error.toString());
        console.error("Caught error:", error, info);
        this.setState({ hasError: true });
    }

    // 5. Render the component's UI
    render() {
        // If an error occurred, show a fallback message
        if (this.state.hasError) {
            return <h1>Something went wrong. Please try again later.</h1>;
        }

        // While posts are loading, show a loading message
        if (this.state.posts.length === 0) {
            return <div>Loading posts...</div>;
        }

        // Once posts are loaded, map over them and display each one
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ borderBottom: '1px solid #ccc', padding: '10px' }}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;