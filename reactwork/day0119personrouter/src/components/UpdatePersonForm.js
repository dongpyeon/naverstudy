import { Add, ArtTrack } from '@mui/icons-material';
import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const UpdatePersonForm = () => {
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [blood, setBlood] = useState('A');
    const [photo, setPhoto] = useState('1.jpg');

    const navi = useNavigate(); 
    //수정 버튼
    const updateDataEvent=()=>{
        //
        axios.post("/person/update",{name,age,photo,blood,pnum})
        .then(res=>{
            //추가 성공 후 목록으로 이동
            navi("/");
        })
    }

    const {pnum}=useParams();
    const [selectData,setSelectData]=useState('');
    //pnum에 대한 dto를 얻어서 selectData에 
    
    const getSelectData=()=>{
        const url="/person/select?pnum="+pnum;
        axios.get(url)
        .then(res=>{
            setName(res.data.name)
            setAge(res.data.age)
            setBlood(res.data.blood)
            setPhoto(res.data.photo)
        })
    }
    
    //처음 로딩 시 딱 한번 호출
    useEffect(()=>{
        getSelectData();
    },[]);
    return (
        <div className='mainbox'>
            <Alert variant='filled' severity='info'>
                Person 멤버 수정
            </Alert>
            <div style={{ marginTop: '20px' }}>
                <table className='table'>
                    <tbody>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                이름
                            </th>
                            <td>
                                <input type='text' value={name}
                                    style={{ width: '150px' }}
                                    className='form-control'
                                    onChange={(e) => setName(e.target.value)} />
                            </td>
                        </tr>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                나이
                            </th>
                            <td>
                                <input type='text' value={age}
                                    style={{ width: '150px' }}
                                    className='form-control'
                                    onChange={(e) => setAge(e.target.value)} />
                            </td>
                        </tr>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                혈액형
                            </th>
                            <td className='input-group'>
                               <select className='form-select'
                               style={{width:'150px'}}
                               onChange={(e)=>setBlood(e.target.value)}
                               value={blood}
                               >
                                <option>A</option>
                                <option>B</option>
                                <option>O</option>
                                <option>AB</option>
                               </select>
                            </td>
                        </tr>
                        <tr>
                            <th style={{ width: '100px', backgroundColor: '#ccc' }}>
                                사진
                            </th>
                            <td className='input-group'>
                                <img alt='' src={require(`../images/${photo}`)}
                                style={{width:'80px', marginRight:'10px'}}/>
                               <select className='form-select'
                               style={{width:'150px', height:'40px'}}
                               onChange={(e)=>setPhoto(e.target.value)}
                               value={photo}
                               >
                                {
                                    [...new Array(20)].map((a,idx)=>(
                                        <option>{idx+1}.jpg</option>))
                                }
                               </select>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} align='center'>
                                <button className='btn btn-outline-secondary'
                                onClick={updateDataEvent}>
                                    <Add/>
                                    <span style={{marginLeft:'10px'}}>수정</span>
                                </button>

                                <button className='btn btn-outline-secondary'
                                style={{marginLeft:'10px'}}
                                onClick={()=>navi("/")}>
                                    <ArtTrack/>
                                    <span style={{marginLeft:'10px'}}>목록</span>
                                </button>

                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default UpdatePersonForm;