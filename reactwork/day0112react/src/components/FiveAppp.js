import React, { useState } from 'react';
import c5 from '../images/팜5.jpg';
import s1 from '../images/팜1.jpg';
import s2 from '../images/팜2.jpg';
import s3 from '../images/팜3.jpg';
import s4 from '../images/팜4.jpg';
import s5 from '../images/팜5.jpg';

function FiveApp(props) {  
    const [show,setShow]=useState(true);
    const [photo,setPhoto]=useState(s1);
    const [border,setBorder]=useState('inset');

    return (
        <div className='box'>
            <h3 className='alert alert-warning'>FiveApp
                <img alt='' src={c5}
                    style={{width:'60px',float:'right'}}>
                </img>
            </h3>
            <div>
                <label>
                    <input type='checkbox' defaultChecked
                    onClick={(e)=>{
                        setShow(e.target.checked);
                    }}/>
                    이미지 보이기/숨기기
                </label>
                <br/><br/>

                사진설정
                <select className='form-select' style={{width:'200px'}}
                onChange={(e)=>{
                    setPhoto(e.target.value);
                }}>
                    <option value={s1}>퀸팜</option>
                    <option value={s2}>브이팜</option>
                    <option value={s3}>모자팜</option>
                    <option value={s4}>모델팜</option>
                    <option value={s5}>하트팜</option>
                </select>
                <br/><br/>

                테두리설정
                <select className='form-select' style={{width:'200px'}}
                onChange={(e)=>{
                    setBorder(e.target.value);
                }}>
                    <option>inset</option>
                    <option>dotted</option>
                    <option>solid</option>
                    <option>dashed</option>
                    <option>double</option>
                    <option>groove</option>
                </select>
                {
                    //show 값이 true면 이미지가 보이고, false면 안보인다
                    show &&
                    <img alt='' src={photo} style={{border:`10px ${border} gray`}}/>
                }
            </div>
        </div>
    );
}

export default FiveApp;