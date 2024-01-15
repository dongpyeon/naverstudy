import React, { useState } from 'react';
//import OneApp from './OneApp'; //default로 export 한 경우
import {OneApp} from './OneApp'; //default 없이 export
import Twoapp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveAppp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';
import EightApp from './EightApp';

function MainApp(props) {
    const [comp,setComp]=useState(5); //컴포넌트 번호 5번이라는 뜻

    return (
        <div>
            <h3>2024-01-12 리액트 수업</h3>
            <hr/>
            <select className='form-select' style={{width:'300px'}}
            onChange={(e)=>{
                setComp(Number(e.target.value));
            }}>
                <option value={1}>OneApp -이미지,스타일,클래스</option>
                <option value={2}>TwoApp -숫자 올리기,내리기 이벤트</option>
                <option value={3}>ThreeApp -이름, 점수입력, 이벤트</option>
                <option value={4}>FourApp -Radio </option>
                <option value={5} selected>FiveApp -check box, select 이미지 이벤트</option>
            </select>
            <br/>
            <h5>당신은 {comp} 번 컴포넌트를 선택했습니다</h5>
            <br/>
            {
                comp==1?<OneApp/>: 
                comp==2?<Twoapp/>: 
                comp==3? <ThreeApp/>: 
                comp==4? <FourApp/>: 
                comp==5? <FiveApp/>: 
                comp==6? <SixApp/>: 
                comp==7? <SevenApp/>: 
                <EightApp/>
            }
        </div>
    );
}

export default MainApp;