import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { Route, RouterProvider, createBrowserRouter, createRoutesFromElements } from 'react-router-dom'
import Layout from './Component/Layout/Layout.jsx'
import Home from './Component/Home/Home.jsx'
import './App.css'
import RegisterUser from './User/RegisterUser.jsx'
import LoginUser from './User/LoginUser.jsx'
import { Provider } from 'react-redux'
import store from './Store/Store.js'
import MenuItemCard from './Component/Menu/MenuItemCard.jsx'
import AddMenuTitle from './Component/AddMenuTitle.jsx'
import AddMenuItem from './Component/AddMenuItem.jsx'

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path='/' element = {<Layout/>}>
      <Route path = '/' element = {<Home/>} />
      <Route path='/signup' element = {<RegisterUser/>} />
      <Route path='/login' element = {<LoginUser/>} />
      <Route path='/:menutitle/menu-items' element = {<MenuItemCard/>} />
      <Route path='/add-title' element = {<AddMenuTitle/>} />
      <Route path='/add-menu-item' element = {<AddMenuItem/>} />
    </Route>
  )
)

ReactDOM.createRoot(document.getElementById('root')).render(


  <React.StrictMode>
    <Provider store={store}>
    <RouterProvider router={router}/>
    </Provider>
  </React.StrictMode>,
)
