import { Button } from '@mui/material';
import React from 'react';

const PersonRowItem = (props) => {
    const {row,idx,onDelete}=props;
    return (
        <tr>
            <td style={{width:'250px'}}>
                <img alt='' src={require(`../images/${row.photo}`)}
                style={{width:'250px',border:'2px solid gray'}}></img>
            </td>
            <td valign='middle'>
                <h5>번호 : {idx+1}</h5>
                <h5>이름 : {row.name}</h5>
                <h5>나이 : {row.age}세</h5>
                <h5>혈액형 : {row.blood}형</h5>
                <h5>등록일 : {row.writeday}</h5>
                <br/><br/>
                <Button color='success' variant='outlined'
                onClick={()=>onDelete(row.pnum)}>
                    회원삭제
                </Button>
            </td>
        </tr>
    );
};

export default PersonRowItem;