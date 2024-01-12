import React, { useState } from 'react';
import c2 from '../images/팜2.jpg';

function ThreeApp(props) {
    const [irum,setIrum]=useState('설석현');
    const [spring,setSpring]=useState(80);
    const [react,setReact]=useState(77);
    const inputStyle={
        marginLeft:'10'
    }
    const resultStyle={
        position:'absolute',
        left:'300px',
        top:'100px'
    }
    return (
        <div className='box'>
            <h3 className='alert alert-success'>ThreeApp
                <img src={c2} 
                style={{width:'60px',float:'right'}}></img>

            </h3>
            <div style={{width:'200px'}}>
                    <div className='input-group'>
                        <h4>이름</h4>
                        <input type='text' className='form-control'
                        style={inputStyle}
                        value={irum}
                        onChange={(e)=>{
                            setIrum(e.target.value);
                        }}></input>
                    </div>
                    <div className='input-group'>
                        <h4>스프링점수</h4>
                        <input type='text' className='form-control'
                        style={inputStyle}
                        value={spring}
                        onChange={(e)=>{
                            setSpring(Number(e.target.value));
                        }}></input>
                    </div>
                    <div className='input-group'>
                        <h4>리액트점수</h4>
                        <input type='text' className='form-control'
                        style={inputStyle}
                        value={react}
                        onChange={(e)=>{
                            setReact(Number(e.target.value));
                        }}></input>
                    </div>
                </div>

                <div style={resultStyle}>
                이름 : {irum} <br/>
                스프링 점수 : {spring}점<br/>
                리액트 점수 : {react}점<br/>
                총점 : {spring+react}점<br/>
                평균 : {(spring+react)/2}점<br/>
                {/* 평균이 90이상은 "장학생",80이상은 "우등생", 나머지는 : "노력" */}
                등급 : {(spring+react)/2>=90?"설서켠":(spring+react)/2>=80?"설석현정도":"설석현"}
            </div>
        </div>
    );
}

export default ThreeApp;