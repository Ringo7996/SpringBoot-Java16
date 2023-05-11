import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import CartPage from './components/CartPage'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <CartPage />

    </>
  )
}

export default App
