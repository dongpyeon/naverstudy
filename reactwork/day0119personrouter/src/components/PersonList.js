import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import PersonRowItem from './PersonRowItem';

const PersonList = () => {

    const [list,setList] = useState([]);

    const navi=useNavigate();

    const PersonList=()=>{
        axios.get("/person/list")
        .then(res=>{
            setList(res.data);
        })
    }

    const deletePerson=(pnum)=>{
        axios.delete("person/delete?pnum="+pnum)
        .then(res=>{
            //삭제 후 목록 다시 출력
            PersonList();
        })
    }

    useEffect(()=>{
        PersonList();
    },[]);

    return (
        <div className='mainbox'>
            <Button color='success' variant='outlined'
            onClick={()=>navi("/writeform")}>멤버추가</Button>
            <br/>
            <br/>
            <Alert variant='filled' severity='info'>
                Person 멤버 목록
            </Alert>
            <h5>총 {list.length}명의 멤버가 있습니다.</h5>
            <table className='table table-bordered'>
                <thead>
                    <tr>
                        <th style={{width:'80px',backgroundColor:'orange'}}>번호</th>
                        <th style={{width:'300px',backgroundColor:'orange'}}>회원명</th>
                        <th style={{width:'120px',backgroundColor:'orange'}}>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        list&&
                        list.map((row,idx)=>(
                            <PersonRowItem key={idx} row={row} idx={idx} deletePerson={deletePerson}/>
                        ))
                    }
                </tbody>

            </table>
        </div>
    );
};

export default PersonList;