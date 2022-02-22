import React, { useState } from 'react'
import InputLabel from '@mui/material/InputLabel'
import MenuItem from '@mui/material/MenuItem'
import Select from '@mui/material/Select'
import Button from '@mui/material/Button'
import axios from 'axios'
import './styles.css'
export function BuildPC() {
    const formRef = React.useRef()
    const [components, setComponents] = useState([])
    const [compatibility, setCompatibility] = useState('')

    function onSubmit() {
        if (formRef.current.reportValidity()) {
            axios.post('http://localhost:8010/pc-builder/pc/builds', 
                    { 
                        compatibility
                    }
                )
                .then(response => setComponents(response.data))
        }       
    }

    return (
        <div className='container'>
            <h1>Montagem de Computador</h1>
            <form className='filter-box' ref={formRef}>
                <div className='filter-item'>
                    <InputLabel required id="demo-simple-select-label">Compatibilidade</InputLabel>
                    <Select
                        required
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        value={compatibility}
                        label="Compatibilidade"
                        onChange={event => setCompatibility(event.target.value)}
                        className="select"
                        variant="standard"
                    >
                        <MenuItem value={'A'}>A</MenuItem>
                        <MenuItem value={'B'}>B</MenuItem>
                        <MenuItem value={'C'}>C</MenuItem>
                        <MenuItem value={'D'}>D</MenuItem>
                    </Select>
                </div>
                <div className='filter-item'>
                    <Button variant="contained" size="large" onClick={() => onSubmit()}>MONTAR</Button>
                </div>
            </form>
            <div className='scroll-box'>
                {components && components.map((item) => {
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
