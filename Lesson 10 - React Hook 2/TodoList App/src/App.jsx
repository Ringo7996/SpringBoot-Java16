import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import TodoList from './components/TodoList'
import TodoItem from './components/TodoItem';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
  
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
    <TodoList/>
    </div>
  )
}

export default App
