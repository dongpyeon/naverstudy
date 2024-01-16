import { DeleteForeverOutlined, DeleteForeverRounded } from '@mui/icons-material';
import { Button } from '@mui/material';
import React, { useState } from 'react';

function ThreeApp(props) {
    const [inputArray, setInputArray] =useState([]);
    const [inputs,setInputs] = useState({
        name:'sul',
        nickname:'suckhyeon',
        hp:'010',
        addr:'Hell'
    });

    //입력시 inputs의 해당 멤버변수로 값이 들어가게 하기 위한 이벤트
    const inputChangeEvent=(e)=>{
        const {name,value}=e.target;//이벤트가 발생하는 태그의 name과 입력값 얻기
        setInputs({
            ...inputs,//기존의 값을 펼침연산자로 일단 넣고, 
            [name]:value //입력한 태그의 name에 값변경을 하는 것이다.
        })

    }

    //배열추가 이벤트
    const arrayAddEvent=()=>{
        //기본 배열데이타에 묶음변수인 inputs 추가
        setInputArray(inputArray.concat(inputs));
    }

    //입력값 초기화
    const clearButtonEvent=()=>{
        setInputs({
            name:'',
            nickname:'',
            hp:'',
            addr:''
        })
    }

    //삭제 이벤트에서 호출해야함
    const deleteData=(idx)=>{
        setInputArray(inputArray.filter((a,i)=>i!==idx));
    }
    return (
        <div style={{width:'460px'}}>
            <h3 className='alert alert-info'>ThreeApp-하나의 변수에 여러값 저장하기</h3>
            <table className='table table-bordered'>
                <tbody>
                    <tr>
                        <th style={{width: '100px'}}>이름</th>
                        <td>
                            <input type='text' className='form-control'
                            value={inputs.name} name='name'
                            onChange={inputChangeEvent}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width: '100px'}}>닉네임</th>
                        <td>
                            <input type='text' className='form-control'
                            value={inputs.nickname} name='nickname'
                            onChange={inputChangeEvent}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width: '100px'}}>핸드폰</th>
                        <td>
                            <input type='text' className='form-control'
                            value={inputs.hp} name='hp'
                            onChange={inputChangeEvent}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width: '100px'}}>주소</th>
                        <td>
                            <input type='text' className='form-control'
                            value={inputs.addr} name='addr'
                            onChange={inputChangeEvent}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={5}>
                            <h5>
                                name:{inputs.name}<br/>
                                nickname:{inputs.nickname}<br/>
                                hp:{inputs.hp}<br/>
                                addr:{inputs.addr}<br/>
                            </h5>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button color='info' variant='outlined'
                            onClick={arrayAddEvent}>
                                배열에 추가
                            </Button>
                            <Button color='info' variant='outlined'
                            onClick={clearButtonEvent}>
                                입력값 초기화
                            </Button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr/>
            {/**배열값 출력 */}
            <table className='table table-bordered'>
                <caption align='top'>배열갯수 : {inputArray.length}</caption>
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>닉네임</th>
                        <th>핸드폰</th>
                        <th>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        inputArray.map((item,idx)=>
                        <tr key={idx}>
                            <td>
                                {item.name}
                                &nbsp;&nbsp;
                                <DeleteForeverRounded style={{cursor:'pointer'}}
                                onClick={(e)=>deleteData(idx)}/>
                            </td>
                            <td>{item.nickname}</td>
                            <td>{item.hp}</td>
                            <td>{item.addr}</td>
                        </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}

export default ThreeApp;