import { ArrowBack, EditNote } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const DetailPerosn = () => {
    const {pnum}=useParams();
    const [selectData,setSelectData]=useState('');
    const navi=useNavigate();
    //pnum에 대한 dto를 얻어서 selectData에 
    
    const getSelectData=()=>{
        const url="/person/select?pnum="+pnum;
        axios.get(url)
        .then(res=>{
            setSelectData(res.data);
        })
    }
    
    //처음 로딩 시 딱 한번 호출
    useEffect(()=>{
        getSelectData();
    },[]);
    return (
        <div className='mainbox'>
            <h2><b>{selectData.name}</b>님의 개인정보</h2>
            {
                selectData.photo&&            
                <img alt='' src={require(`../images/${selectData.photo}`)}
                style={{maxWidth:'350px'}}></img>
            }
            <hr/>
            <h6>혈액형 : {selectData.blood}형
            
            <EditNote style={{fontSize:'2em', float:'right',cursor:'pointer'}}
            onClick={()=>navi(`/updateform/${selectData.pnum}`)}/>
            </h6>
            <h6>나  이 : {selectData.age}세</h6>
            <h6>가입일 : {selectData.writeday}
            <ArrowBack
            //-1 : 이전페이지로 이동을 뜻함.
            style={{fontSize:'2em',float:'right',cursor:'pointer'}}
            onClick={()=>navi(-1)}/>
            
            </h6>
        </div>
    );
};

export default DetailPerosn;