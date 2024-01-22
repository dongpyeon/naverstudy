import React from 'react';
import img1 from '../image/01.png';
import img2 from '../image/02.png';
import img3 from '../image/03.png';
import img4 from '../image/04.png';
import img5 from '../image/05.png';
import { Button } from '@mui/material';
import Swal from 'sweetalert2';
const SweetApp = () => {
    return (
        <div>
            <h3 className='alert alert-danger'>SweetAlert 사용법</h3>
            <hr/>
            <Button variant='outlined' color='error'
            onClick={()=>{
                Swal.fire({
                    title:'Swal Test',
                    html:"석현이는 <br/>쪼개고있어요<br/>형을 막 때리네요 <br/>짜증났어요!!!",
                    icon:"warning",
                    confirmButtonText:"확인",
                    confirmButtonColor:'#3085d6',
                    cancelButtonText:"취소",
                    cancelButtonColor:'red',
                    showCancelButton:true
                }).then(result=>{
                    if(result.isConfirmed){
                        Swal.fire("시키는대로 처리했어요!");
                    }else{
                        Swal.fire("취소했어요!!!");
                    }
                });
            }}>확인,취소Alert</Button>
            <br/>
            <button type='button' className='btn btn-success'
            onClick={()=>{
                Swal.fire({
                    title:"사진넣기",
                    html:`<h5>사진을 넣어볼까요!!</h5>`,
                    imageUrl:img4,
                    imageWidth:100
                })
            }}>
                사진넣기
            </button>
        </div>
    );
};

export default SweetApp;