import React, { useState } from 'react';

function SevenApp(props) {
    const [array,setArray] = useState([
        {title:"귀여운 원시인",price:"23000",color:"orange",photo:"C1"},
        {title:"귀여운 배트맨",price:"11000",color:"pink",photo:"C3"},
        {title:"뚱석현",price:"30400",color:"green",photo:"C2"},
        {title:"커여운 헐크",price:"30400",color:"purple",photo:"C5"},
    ]);

    //const [data,setData]=useState('');
    return (
        <div>
            <h3 className='alert alert-danger'>SevenApp</h3>
            <table className='table table-bordered' style={{width:"400px"}}>
                <tbody>
                 {
                    array.map((item,i)=>(
                        <tr key={i}>
                            <td style={{width:'150px'}}>
                                <img alt='' src={require(`../iamges/${item.photo}.png`)}/>
                            </td>
                            <td>
                                제목 : {item.title} <br/>
                                가격 : {item.price}원<br/>
                                색상 : <b style={{backgroundColor:item.color}}>{item.color}</b><br/>
                                <button type='button'
                                className='btn btn-danger btn-sm'
                                onClick={()=>{
                                setArray(array.filter((a,idx)=>(i!==idx)))
                            }}>Delete</button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    );
}

export default SevenApp;