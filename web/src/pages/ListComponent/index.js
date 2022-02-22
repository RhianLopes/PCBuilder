import React, { useState, useEffect } from 'react'
import TextField from '@mui/material/TextField'
import InputLabel from '@mui/material/InputLabel'
import MenuItem from '@mui/material/MenuItem'
import Select from '@mui/material/Select'
import axios from 'axios'
import './styles.css'

export function ListComponent() {
    const [components, setComponents] = useState([])
    const [brand, setBrand] = useState('')
    const [model, setModel] = useState('')
    const [category, setCategory] = useState('')

    useEffect(() => {
        axios.get('http://localhost:8010/pc-builder/components', 
                { 
                    params: {
                        brand: brand,
                        model: model,
                        category: category
                    }
                }
            )
            .then(response => setComponents(response.data))
    }, [brand, model, category])
    
    return (
        <div className='container'>
            <h1>Listagem de Componentes</h1>
            <div className='filter-box'>
                <div className='filter-item exception'>
                    <TextField id="outlined-basic" label="Marca" variant="standard" onChange={event => setBrand(event.target.value)}/>
                </div>
                <div className='filter-item exception'>
                    <TextField id="outlined-basic" label="Modelo" variant="standard" onChange={event => setModel(event.target.value)}/>
                </div>
                <div className='filter-item'>
                    <InputLabel id="demo-simple-select-label">Categoria</InputLabel>
                    <Select
                      labelId="demo-simple-select-label"
                      id="demo-simple-select"
                      value={category}
                      label="Categoria"
                      onChange={event => setCategory(event.target.value)}
                      className="select"
                      variant="standard"
                    >
                        <MenuItem value={'MOTHERBOARD'}>PLACA-MÃE</MenuItem>
                        <MenuItem value={'MEMORY'}>MEMÓRIA</MenuItem>
                        <MenuItem value={'HD'}>HD</MenuItem>
                        <MenuItem value={'PROCESSOR'}>PROCESSADOR</MenuItem>
                    </Select>
                </div>
            </div>
            <div className='scroll-box'>
                {components.map((item) => {
                    return (
                        <div className='list-item' key={item.id}>
                            <h2>{item.id} - {item.model}</h2>
                            <div><b>Marca:</b> {item.brand}</div>
                            <div><b>Categoria:</b> {item.category}</div>
                            <div><b>Compatibilidade:</b> {item.compatibility}</div>
                            <div><b>Preço:</b> {item.price.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'}).replace(".", ",")}</div>
                        </div>
                    )
                })}
            </div>
        </div>
    )
}
