import React from 'react'
import './styles.css'
import { SidebarData } from '../../constants/sidebardata'

export function Sidebar() {

    return (
        <div className='sidebar'>
            <ul className='sidebar-list'>
                {SidebarData.map((item, key) => {
                    return (
                        <li
                          key={key}
                          className='sidebar-item'
                          onClick={() => {
                              window.location.pathname = item.link
                          }}
                        >
                            <div className='icon'>{item.icon}</div>
                            <div className='title'>{item.title}</div>
                        </li>
                    )
                })}
            </ul>
        </div>
    )
}
