import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

function OneApp(props) {
    //count 증가를 하나는 state로 하나는 ref로 선언 후 증가시켜보자!
    const[count,setCount]=useState(0);
    const countRef=useRef(0);
    return (
        <div>
            <Alert security='danger' variant='filled'>
                <h3>OneApp-useRef : 값이 변경되도 화면이 다시 렌더링 되지 않는다.</h3>
            </Alert>
            <h1>state : {count}</h1>
            <h1>ref : {countRef.current}</h1>
            <hr/>
            <Button variant='outlined' color='success'
            onClick={()=>setCount(count+1)}>state count 변수 증가</Button>
            <br/>
            <Button variant='outlined' color='primary' size='small'
            onClick={()=>{
                countRef.current=countRef.current+1; //버튼을 클릭해도 렌더링
                console.log("countRef.current="+countRef.current);
            }}>ref count 변수 증가</Button>
        </div>
    );
}

export default OneApp;