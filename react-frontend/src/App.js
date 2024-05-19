import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Board from "./components/Board";

class App extends Component {
  render() {
    return (
      <Router>
      <Board/>
        <div>
          <Routes>
            <Route path="/" component={Board} />
          </Routes>
        </div>
      </Router>
    );
  }
}

export default App;