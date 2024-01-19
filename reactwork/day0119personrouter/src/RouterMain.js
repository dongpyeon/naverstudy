import React from 'react';
import { Route, Routes } from 'react-router-dom';
import PersonList from './components/PersonList';
import PersonForm from './components/PersonForm';
import DetailPerosn from './components/DetailPerosn';
import UpdatePersonForm from './components/UpdatePersonForm';
import errimg from './images/10.png'
import './components/PersonStyle.css'

const RouterMain = () => {
    return (
        <div>
            <Routes>
                <Route path='/' element={<PersonList/>}></Route>
                <Route path='/writeform' element={<PersonForm/>}></Route>
                <Route path='/detail/:pnum' element={<DetailPerosn/>}></Route>
                <Route path='/updateform/:pnum' element={<UpdatePersonForm/>}></Route>

                {/**그 이외의 매핑주소일 경우 호출 */}
                <Route path='*' element={
                    <div style={{margin:'50px'}}>
                        <h1>잘못된 URL 주소입니다</h1>
                        <img alt='' src={errimg}/> 뭘봐 ㅋㅋ
                    </div>
                }/>
            </Routes>
        </div>
    );
};

export default RouterMain;