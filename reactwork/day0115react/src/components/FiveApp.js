import React, { useState } from 'react';
import '../MyStyle.css';

function FiveApp(props) {
    const [msg, setMsg] = useState(['Happy', 'Hello', '안녕하세요']);
    return (
        <div>
            <h3 className='alert alert-success'>FiveApp</h3>
            <input type='text' className='from-control'
                style={{ width: '200px' }} placeholder='메세지 입력'
                onKeyUp={(e) => {
                    if (e.key === 'Enter') {    //엔터키를 눌렀을때 의 펑션
                        //alert(e.target.value);

                        //배열에 push로 일단 추가해보자
                        //setMsg(msg.push(e.target.value)); //당연히 오류발생함

                        //리액트는 push 말고 concat으로 해야함
                        setMsg(msg.concat(e.target.value));
                    }
                }} />
            <hr />

            <h6 className='alert alert-success'>
                총 {msg.length}개의 메세지가 있습니다. - 더블클릭시 삭제
            </h6>
            <br />
            {
                msg.map((m, i) => (<h6 key={i} className='select'
                    onDoubleClick={(e) => {
                        //방법1 : slice
                        // setMsg([
                        //     ...msg.slice(0, i),
                        //     ...msg.slice(i + 1, msg.length)
                        //     ]
                        // )

                        //방법 2 : filter
                        setMsg(msg.filter((item,idx)=>i!==idx));
                    }}>{i + 1}:{m}</h6>))
            }

        </div>
    );
}

export default FiveApp;