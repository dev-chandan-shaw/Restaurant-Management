import React, { useState } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'

const RegisterUser = () => {
  const navigate = useNavigate()
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  })

  const handleInputChange = (e) => {
    const {name, value} = e.target;
    setFormData((prevFormData) =>  ({...prevFormData, [name]: value,}))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    axios.post("http://localhost:8080/auth/signup",formData)
        .then(response => response.json())
        .then(data => console.log(data))
    navigate("/")
  }
  return (
    <div className='border-2 m-auto mt-10 rounded-sm py-3 p-10 w-[350px] shadow-lg'>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="name">Name</label>
            <input 
            type="text"
            name='name'
            value={formData.name}
            onChange={handleInputChange}
            className='border w-full block rounded-sm ring-gray-300 ring-inset p-1 ring-1'
            />
          </div>

          <div>
          <label htmlFor="email">Email</label>
            <input 
            type="text"
            name='email'
            value={formData.email}
            onChange={handleInputChange}
            className='border w-full block rounded-sm ring-gray-300 ring-inset p-1 ring-1'
            />
          </div>

          <div>
          <label htmlFor="email">Password</label>
            <input 
            type="text"
            name='password'
            value={formData.password}
            onChange={handleInputChange}
            className='border w-full block rounded-sm ring-gray-300 ring-inset p-1 ring-1'
            />
          </div>
          <div className="mt-6 flex items-center justify-end gap-x-6">
          <Link to="/" className="text-sm font-semibold leading-6 text-gray-900">
            Cancel
          </Link>
          <button
            type="submit"
            className="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            Save
          </button>
        </div>
        
        </form>
    </div>
  )
}

export default RegisterUser