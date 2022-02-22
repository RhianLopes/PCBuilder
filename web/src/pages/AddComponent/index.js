import React, { useState } from 'react'
import TextField from '@mui/material/TextField'
import InputLabel from '@mui/material/InputLabel'
import MenuItem from '@mui/material/MenuItem'
import Select from '@mui/material/Select'
import Button from '@mui/material/Button'
import CurrencyTextField from '@unicef/material-ui-currency-textfield'
import axios from 'axios'
import './styles.css'
export function AddComponent() {
    const formRef = React.useRef()
    const [brand, setBrand] = useState('')
    const [model, setModel] = useState('')
    const [category, setCategory] = useState('')
    const [price, setPrice] = useState(0.0)
    const [compatibility, setCompatibility] = useState('')

    function onSubmit() {
        if (formRef.current.reportValidity()) {
            axios.post('http://localhost:8010/pc-builder/components', 
                    { 
                        brand,
                        model,
                        category,
                        price,
                        compatibility
                    }
                )
                .then(() => window.location.href = '/componentes')
        }       
    }

    return (
        <div className='container'>
            <form className='box' ref={formRef}>
                <h1 className='title'>Cadastro de Componentes</h1>
                <div className='add-box'>
                    <div className='add-box-left'>
                        <div className='add-field exception'>
                            <TextField required id="outlined-basic" className='field' label="Marca" variant="standard" onChange={event => setBrand(event.target.value)}/>
                        </div>
                        <div className='add-field exception'>
                            <TextField required id="outlined-basic" className='field' label="Modelo" variant="standard" onChange={event => setModel(event.target.value)}/>
                        </div>
                        <div className='add-field exception'>
                            <CurrencyTextField
                                required
                                label="Preço"
                                variant="standard"
                                className='field'
                                value={price}
                                currencySymbol="R$"
                                outputFormat="number"
                                onChange={(event, value)=> setPrice(value)}
                            />
                        </div>
                    </div>
                    <div className='add-box-right'>
                        <div className='add-field'>
                            <InputLabel required id="demo-simple-select-label">Categoria</InputLabel>
                            <Select
                                required
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={category}
                                label="Categoria"
                                onChange={event => setCategory(event.target.value)}
                                className="field"
                                variant="standard"
                            >
                                <MenuItem value={'MOTHERBOARD'}>PLACA-MÃE</MenuItem>
                                <MenuItem value={'MEMORY'}>MEMÓRIA</MenuItem>
                                <MenuItem value={'HD'}>HD</MenuItem>
                                <MenuItem value={'PROCESSOR'}>PROCESSADOR</MenuItem>
                            </Select>
                        </div>
                        <div className='add-field'>
                            <InputLabel required id="demo-simple-select-label">Compatibilidade</InputLabel>
                            <Select
                                required
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={compatibility}
                                label="Compatibilidade"
                                onChange={event => setCompatibility(event.target.value)}
                                className="field"
                                variant="standard"
                            >
                                <MenuItem value={'A'}>A</MenuItem>
                                <MenuItem value={'B'}>B</MenuItem>
                                <MenuItem value={'C'}>C</MenuItem>
                                <MenuItem value={'D'}>D</MenuItem>
                            </Select>
                        </div>
                    </div>
                </div>
                <div className='add-button'>
                    <Button variant="contained" size="large" onClick={() => onSubmit()}>CADASTRAR</Button>
                </div>
            </form>
        </div>
    )
}
