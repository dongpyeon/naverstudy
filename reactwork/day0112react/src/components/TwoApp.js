import React, { useState } from 'react';
import "./MyStyle.css"
import c2 from '../images/팜3.jpg';
function Twoapp(props) {
    //함수형에서 state 변수 선언하는 방법
    const [number,setNumber]=useState(0);
    
    return (
        <div className='box'>
            <h3 className='alert alert-success'>TwoApp
                <img src={c2} 
                style={{width:'60px',float:'right'}}></img>
            </h3>
            <div style={{fontSize:'40px',color:'red',marginLeft:'200px'}}>
                {number}
            </div>
            <div style={{marginLeft:'130px'}}>
                <button type='button' className='btn btn-outline-success'
                onClick={()=>{
                    if(number===0){//== 값만 비교, ===값과 타입까지 비교
                        alert("0이하로 못뺍니단 ㅋㅋ");
                        return;//함수 종료
                    }
                    setNumber(number-1);
                }}
                >숫자감소</button>

                <button type='button' className='btn btn-outline-success'
                style={{marginLeft:'10px'}}
                onClick={()=>{
                    if(number===10){//== 값만 비교, ===값과 타입까지 비교
                        alert("10 이상 증가할 수 없습니단 ㅋㅋ");
                        return;//함수 종료
                    }
                    setNumber(number+1);
                }}>숫자증가</button>
                

            </div>
        </div>
    );
}

export default Twoapp;