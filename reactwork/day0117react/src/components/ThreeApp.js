import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import ThreeCardApp from './ThreeCardApp';

function ThreeApp(props) {

    const [personList, setPersonList] = useState([]);

    const list = () => {
        //백엔드로 부터 데이타를 가져와서 배열변수에 넣기
        axios.get("/person/list")
            .then(res => {
                setPersonList(res.data);
            })
    }

    useEffect(()=>{
        list(); //처음 시작 시 무조건 호출
    },[]) //처음 시작 시 한번만 호출

    return (
        <div>
            <Alert severity='warning' variant='filled'>
                <h3>ThreeApp-mui Card를 이용한 </h3>
                {
                    personList.map((item,idx)=>(
                        <div>
                        <ThreeCardApp key={idx} item={item}/>
                        <hr/>
                        </div>
                    ))
                }               
            </Alert>
        </div>
    );
}

export default ThreeApp;