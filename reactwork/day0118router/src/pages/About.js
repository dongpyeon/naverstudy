import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';
import simg from '../images/팜1.jpg'
import gimg from '../images/팜2.jpg'

const About = () => {
    const { emp } = useParams();
    console.log({ emp });
    console.log({ emp }.emp);

    return (

        <div>
            <Alert variant='filled' severity='success'>
                About 컴포넌트입니다.
            </Alert>
            {
                emp==null?
                    <div>
                        <h1>저는 취업준비생입니다</h1>
                        <img alt='' src={require(`../images/팜4.jpg`)}></img>
                    </div>
                    :
                    //emp값이 있는 경우 실행할 영역
                    <div>
                        <h1>저는 {emp}에 다니고 있습니다</h1>
                        <img alt='' src={(emp === 'Samsung' ? simg : gimg)} />
                    </div>

            }
        </div>
    );
};

export default About;