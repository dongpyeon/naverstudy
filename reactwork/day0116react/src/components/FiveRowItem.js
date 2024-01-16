import { DeleteForeverOutlined } from '@mui/icons-material';
import React from 'react';

function FiveRowItem({row,idx,onDelete}) {
    return (
            <tr>
                <td>{idx+1}</td>
                <td>
                    <img alt='' src={require(`../images/${row.fphoto}`)}
                    width={100} height={100} border='1' hspace='10'/>
                    {row.fname}
                </td>
                <td valign='middle'>{row.fprice}원</td>
                <td valign='middle'>
                    {row.fdate.toLocaleDateString('ko-KR')}{/**new Date() 파일이라 이걸 써줘야 오류가 안남 */}
                </td>
                <td valign='middle'>
                    <DeleteForeverOutlined style={{cursor:'pointer'}}
                    onClick={()=>onDelete(idx)}/>
                </td>
            </tr>
    );
}

export default FiveRowItem;