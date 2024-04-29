import axios from 'axios'
import React from 'react'
import { Link } from 'react-router-dom'

function Admin() {
  return (
    <div>
      <div className="flex justify-center gap-2 items-center my-2">
          <h1 className="text-xl font-bold text-center">Add menu title</h1>
          <Link className="px-4 py-1 rounded-lg bg-blue-400" to={"/add-title"} >Add</Link>
        </div>
        <div className="flex justify-center gap-2 items-center my-2">
        <h1 className="text-xl font-bold text-center">Add Menu Title</h1>
          <Link className="px-4 py-1 rounded-lg bg-blue-400" to={"/add-menu-item"} >Add</Link>
        </div>
    </div>
  )
}

export default Admin