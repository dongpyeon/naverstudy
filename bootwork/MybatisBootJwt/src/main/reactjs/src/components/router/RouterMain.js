import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Home from '../Home';
import BoardList from '../board/BoardList';
import LoginForm from '../login/LoginForm';
import MemberForm from '../member/MemberForm';
import MemberList from '../member/MemberList';
import Menu from '../Menu';


const RouterMain = () => {
    return (
        <div style={{margin:'30px'}}>
            <Menu/>
            <br style={{clear:'both'}}/>
            <div style={{marginTop:'30px'}}>
            <Routes>
                <Route path='/' element={<Home/>}/>

                <Route path='/member'>
                    <Route path='list' element={<MemberList/>}/>
                    <Route path='form' element={<MemberForm/>}/>
                </Route>

                <Route path='/board'>
                    <Route path='list' element={<BoardList/>}/>
                </Route>

                <Route path='/login' element={<LoginForm/>}/>


            </Routes>
            </div>
        </div>
    );
};

export default RouterMain;