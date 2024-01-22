import React, { useContext } from 'react';
import { ThemaContext } from './ThemaContext';
import { UserContext } from './UserContext';

const Content = () => {
    const {isDark,doll}=useContext(ThemaContext);
    const user = useContext(UserContext);
    return (
        <div className='content' style={{backgroundColor:isDark?'gray':'white'}}>
            <p>{user}님! 즐거운 하루되세요!!!</p>
            <img alt='' src={require(`../image/${doll}`)} width={100}/>
        </div>
    );
};

export default Content;