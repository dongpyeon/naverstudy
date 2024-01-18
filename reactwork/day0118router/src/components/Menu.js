import React from 'react';
import '../pages/MyStyle.css';
import { NavLink } from 'react-router-dom';

const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={"/home"}>Home</NavLink> {/* a태그 말고 navlink 써야한다네요 */}
                </li>
                <li>
                    <NavLink to={"/about"}>About</NavLink>
                </li>
                <li>
                    <NavLink to={"/about/Samsung"}>About-S사</NavLink>
                </li>
                <li>
                    <NavLink to={"/about/Google"}>About-G사</NavLink>
                </li>
                <li>
                    <NavLink to={"/food"}>Food</NavLink>
                </li>
                <li>
                    <NavLink to={"/food/1"}>Food-식사1</NavLink>
                </li>
                <li>
                    <NavLink to={"/food/2/1"}>Food-식사2</NavLink>
                </li>
            </ul>
        </div>
    );
};

export default Menu;