import React, { useState } from 'react';
import c2 from '../images/팜3.jpg';


function FourApp(props) {
    const [fname,setFname] =useState('Single Day');
    const [fsize,setFsize] =useState('20px');
    const [fcolor,setFcolor] =useState('blue');

    //이벤트들
    //글자색 변경하는 이벤트
    const changeFontColor=(e)=>{
        setFcolor(e.target.value);
    }
    //폰트 변경
    const changeFontName=(e)=>{
        setFname(e.target.value);
    }
    //글꼴 크기 변경
    const changeFontSize=(e)=>{
        setFsize(e.target.value);
    }
    return (

    <div className='box'>
        <h3 className='alert alert-danger'>FourApp
            <img alt='' src={c2} style={{width:'60px',float:'right'}}/>
        </h3>
        <div style={{fontFamily:fname,fontSize:fsize,color:fcolor}}>
            오늘은 즐거운 금요일!!
        </div>
        <div style={{marginTop:'10px'}}>
            <label>
                <input type='radio' name='fcolor' defaultValue={'red'}
                onClick={changeFontColor}/>빨강
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fcolor' defaultValue={'blue'}
                onClick={changeFontColor}/>파랑
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fcolor' defaultValue={'green'}
                onClick={changeFontColor}/>초록
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fcolor' defaultValue={'magenta'}
                onClick={changeFontColor}/>분홍
            </label>
        </div>

        <div style={{marginTop:'10px'}} onClick={changeFontName}>
            <label>
                <input type='radio' name='fname' defaultValue={'Gamja Flower'}/>Gamja Flower
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fname' defaultValue={'Single Day'}
                defaultChecked/>Single Day
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fname' defaultValue={'Jua'}/>Jua
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fname' defaultValue={'Nanum Pen Script'}/>Nanum Pen Script
            </label>
        </div>

        <div style={{marginTop:'10px'}} onClick={changeFontSize}>
            <label>
                <input type='radio' name='fsize' defaultValue={'13px'}/>아주작게
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fsize' defaultValue={'20px'}
                defaultChecked/>작게
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fsize' defaultValue={'30px'}/>크게
            </label>
            <label style={{marginLeft:'10px'}}>
                <input type='radio' name='fsize' defaultValue={'40px'}/>아주크게
            </label>
        </div>
    </div>
        
    );
}

export default FourApp;