import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { Listing } from 'pages/Listing/index'
import { Form } from 'pages/Form/index'
import { Navbar } from './components/Navbar/index'

export const App = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
        <Route path="/" element={<Listing />} />
      </Routes>
    </BrowserRouter>
  )
}
