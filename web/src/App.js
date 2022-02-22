import { Sidebar } from './components'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { ListComponent, AddComponent, BuildPC } from './pages'
import './App.css'

function App() {
  return (
    <div className='App'>
      <Router>
        <Sidebar/>
        <Routes>
          <Route exact path='/componentes' element={<ListComponent/>}/>
          <Route path='/cadastro-componentes' element={<AddComponent/>}/>
          <Route path='/montar-computador' element={<BuildPC/>}/>
        </Routes>
      </Router>
    </div>
  )
}

export default App
