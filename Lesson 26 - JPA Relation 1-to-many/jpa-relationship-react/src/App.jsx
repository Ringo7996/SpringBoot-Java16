import './App.css'
import FilePage from './components/FilePage'
import UserPage from './components/UserPage'
import { Routes, Route, BrowserRouter } from "react-router-dom";


function App() {
  return (
    <>
      {/* <UserPage />
      <FilePage /> */}


      <Routes>
        <Route path="api/v1/users" element={<UserPage />} />
        <Route path="api/v1/users/:userId/files" element={<FilePage />} />


{/* 
        <Route path="api/v1/users">
          <Route index element={<UserPage />}></Route>
          <Route path=":userId/files" element={<FilePage />}></Route>
        </Route> */}
      </Routes>
    </>
  )
}

export default App
