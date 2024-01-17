import axios from 'axios';
import React, { useState } from 'react';

const FourGuestForm = () => {
    const [photo, setPhoto] = useState('');
    const [nickname, setNickname] = useState('');
    const [content, setContent] = useState('');

    const imgUrl = "https://kr.object.ncloudstorage.com/bitcamp-kdh/bootmyshop/";

    //파일 업로드 이벤트
    const onUploadEvent=(e)=>{
        const uploadFile=new FormData();
        uploadFile.append("upload",e.target.files[0]);

        axios({
            method: 'post',
            url:"/guest/upload",
            data:uploadFile,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=>{
            setPhoto(res.data); //실제 스토리지에 올라간 사진파일명 반환
        })
    }
    return (
        <div>
            <div style={{ width: '400px' }}>
                <input type='file' className='form-control' onChange={onUploadEvent} />
                <img alt='' src={imgUrl + photo} width={130} />
                <b>{photo}</b>
            </div>
        </div>
    );
};

export default FourGuestForm;