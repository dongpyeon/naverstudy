import React, { useContext } from 'react';
import { ThemaContext } from './ThemaContext';

const Footer = () => {
    const {isDark,setIsDark,doll}=useContext(ThemaContext);

    return (
        <footer className='footer' style={{backgroundColor:isDark?'black':'lightgray'}}>
            <button type='button' className='button'
            onClick={()=>setIsDark(!isDark)}>Dark Mode</button>
            <img alt='' src={require(`../image/${doll}`)} width={30}/>
            
        </footer>
    );
};

export default Footer;