import React from 'react';
import Menu from './Menu';
import { Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import CallBackApp from './components/CallBackApp';
import MemoApp from './components/MemoApp';
import ReducerApp from './components/ReducerApp';
import ContextApp from './context/ContextApp';
import SweetApp from './components/SweetApp';
import errimg from './image/07.png';
import './components/MyStyle.css';
import Query from './context/Query';

const RootMain = () => {
    return (
        <div>
            <div className='main'>
                <Menu />
                <div style={{ clear: 'both' }}>
                    <hr />
                    <Routes>
                        <Route path='/' element={<Home />} />
                        <Route path='/callback' element={<CallBackApp />} />
                        <Route path='/memo' element={<MemoApp />} />
                        <Route path='/reducer' element={<ReducerApp />} />
                        <Route path='/context' element={<ContextApp />} />
                        <Route path='/sweet' element={<SweetApp />} />
                        <Route path='/query' element={<Query />} />

                        <Route path='*' element={
                            <div>
                                <h1>잘못된 URL 주소입니다</h1>
                                <br /><br />
                                <img alt='' src={errimg} />
                            </div>
                        }>
                        </Route>
                    </Routes>
                </div>
            </div>
        </div>
    );
};

export default RootMain;