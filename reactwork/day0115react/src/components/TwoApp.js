import React, { useEffect, useState } from 'react';
import c1 from '../팜1.jpg';
import c2 from '../팜2.jpg';
function TwoApp(props) {
    const [show,setShow]=useState(true);
    const [count,setCount]=useState(1);

    const clickButtonEvent=()=>{
        setCount(count+1);
        //setShow(count%3===0?true:false);
    }

    useEffect(()=>{
        setShow(count%3===0?true:false);
    },[count]);//count 변경 시 자동호출
    return (
        <div>
            <h3 className='alert alert-success'>TwoApp-3의 배수마다 이미지 보이기/안보이기</h3>
            <button type='button' className='btn btn-danger'
            onClick={clickButtonEvent}>숫자증가</button>
            <b style={{fontSize:'4em',color:'red', marginLeft:'50px'}}>{count}</b>
            <br/>
            <br/>
            {
                //show가 true일 때 보이는 이미지
                show&&
                <img alt='' src={c1}/>
            }

            {
                //show가 flase일 때 보이는 이미지
                !show &&
                <img alt='' src={c2}/>
            }

            {/**src의 이미지를 import 없이 출력하는 방법 */}
            <img alt='' src={require('../팜5.jpg')}/>
        </div>
    );
}

export default TwoApp;