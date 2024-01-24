import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Swal from 'sweetalert2';

const LoginForm = () => {
    const [myid, setMyid] = useState('');
    const [pass, setPass] = useState('');
    const [token, setToken] = useState('');

    useEffect(()=>{
        let session_token=sessionStorage.token;
        console.log(session_token);
        setToken(session_token);
    },[]) //처음 시작 시 한번만 호출
    let session_token = sessionStorage.session_token;

    const buttonLoginEvent = () => {
        axios.post("/login/auth", { myid, pass })
            .then(res => {
                if (res.data.result === 'noid') {
                    Swal.fire("존재하지 않는 아이디 입니다.");
                } else if (res.data.result === 'nopass') {
                    Swal.fire("비밀번호가 일치하지 않습니다.");
                } else {
                    //토큰을 얻어서 세션 스토리지에 token 이라는 이름으로 저장한다
                    sessionStorage.session_token = res.data.token;
                    setToken(res.data.token);
                }
            })
    }

    return (
        <div>
            <h4 className='alert alert-danger'>로그인 폼</h4>
            {
                token == null ?
                    <div>
                        <h4 className='alert alert-danger'>로그인 폼</h4>
                        <table className='table table-bordered' style={{ width: '250px' }}>
                            <tbody>
                                <tr>
                                    <th width={100} style={{ backgroundColor: '#ccc' }}>아이디</th>
                                    <td>
                                        <input type='text' className='form-control'
                                            value={myid} onChange={(e) => setMyid(e.target.value)} />
                                    </td>
                                </tr>
                                <tr>
                                    <th width={100} style={{ backgroundColor: '#ccc' }}>비밀번호</th>
                                    <td>
                                        <input type='text' className='form-control'
                                            value={pass} onChange={(e) => setPass(e.target.value)} />
                                    </td>
                                </tr>
                                <tr>
                                    <td colSpan={2} align='center'>
                                        <button type='button' className='btn btn-outline-success'
                                            onClick={buttonLoginEvent}>
                                            회원 로그인
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    :
                    <div>
                        <h4 className='alert alert-danger'>로그인 중입니다.</h4>
                        <br /><br />
                        <img alt='' src={require("../../image/05.png")} />
                        <br /><br />
                        <button type='button' className='btn btn-danger'
                            onClick={() => {
                                sessionStorage.removeItem("token");
                                setToken(null);
                                setMyid('');
                                setPass('');
                            }}>로그아웃</button>
                    </div>
            }
        </div>
    );
};

export default LoginForm;