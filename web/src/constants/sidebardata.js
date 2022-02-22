import React from 'react'
import FormatListBulletedIcon from '@mui/icons-material/FormatListBulleted'
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline'
import ComputerIcon from '@mui/icons-material/Computer'


export const SidebarData = [
    {
        title: 'Listagem de Componentes',
        icon: <FormatListBulletedIcon/>,
        link: '/componentes'
    },
    {
        title: 'Cadastro de Componentes',
        icon: <AddCircleOutlineIcon/>,
        link: '/cadastro-componentes'
    },
    {
        title: 'Montagem de Computador',
        icon: <ComputerIcon/>,
        link: '/montar-computador'
    },
]
