import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';
import fooda from '../images/1.jpg'
import foodb from '../images/2.jpg'

const Food = () => {
    const { food1,food2 } = useParams();
    return (
        <div>
            <Alert variant='filled' severity='warning'>
                Food 컴포넌트입니다.
            </Alert>
            {
                food1==null&&food2==null?<h3>저는 오늘 점심식사를 하지 않겠습니다</h3>:
                food1!=null&&food2==null?
                <div>
                    <h4>오늘의 점심 메뉴</h4>
                    <img alt='' src={require(`../images/${food1}.jpg`)} width={300}></img>
                    <h1>오늘 후식은 없습니다</h1>
                </div>:
                <div>
                    <h4>오늘의 점심 메뉴</h4>
                    <img alt='' src={require(`../images/${food1}.jpg`)} width={300}></img>
                    <h4>오늘의 후식</h4>
                    <img alt='' src={require(`../images/${food2}.jpg`)} width={300}></img>
                </div>

            }
        </div>
    );
};

export default Food;