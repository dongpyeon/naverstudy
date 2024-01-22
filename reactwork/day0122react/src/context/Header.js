import React, { useContext } from 'react';
import { ThemaContext } from './ThemaContext';
import { UserContext } from './UserContext';

const Header = () => {
    const {isDark,doll}=useContext(ThemaContext);
    const user =useContext(UserContext); 
    return (
        <header className='header' style={{backgroundColor:isDark?'black':'lightgray'}}>
            <h1>Welcome {user}!
                <img alt='' src={require(`../image/${doll}`)} width={30}/>
            </h1>
        </header>
    );
};

export default Header;