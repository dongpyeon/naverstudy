import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const { num } = useParams();
    const [data, setData] = useState('');
    const navi = useNavigate();
    const imageUrl = process.env.REACT_APP_STORAGE;



    const getdata = () => {
        axios.get("/board/detail?num=" + num)
            .then(res => {
                setData(res.data);
            })
    }

    useEffect(() => {
        getdata();
    }, []);

    return (
        <div>
            {
                data &&
                <div style={{ margin: '50px', width: '700px' }}>
                    <h3><b>{data.subject}</b></h3>
                    <div className='input-group'>
                        <h5>
                            {data.writer}({data.myid})
                        </h5>
                        <span style={{ marginLeft: '100px', color: 'gray' }}>
                            조회 {data.readcount}
                        </span>
                        <span style={{ marginLeft: '100px', color: 'gray' }}>
                            {data.writeday}
                        </span>
                    </div>
                    <div className='input-group' style={{ marginTop: '20px' }}>
                        {
                            data.photo == '' ? "" :
                                <img alt='' src={imageUrl + data.photo}
                                    style={{ maxWidth: '300px' }} />
                        }
                    </div>
                    <pre style={{ fontWeight: 'bold', marginTop: '20px' }}>{data.content}</pre>
                    <br /><br />
                    <button type='button' className='btn btn-outline-secondary btn-sm'
                        style={{ width: '80px' }} onClick={() => navi("/board/list")}>
                        목록
                    </button>
                    <button type='button' className='btn btn-outline-secondary btn-sm'
                        style={{ width: '80px', marginLeft: '5px' }} onClick={() => navi("/board/form")}>
                        글쓰기
                    </button>
                </div>
            }
        </div>
    );
};

export default BoardDetail;