import React from 'react';
import mainImage1 from '../image/05.png'
import mainImage2 from '../image/06.png'
const Home = () => {
    return (
        <div>
            <h1>React+SpringBoot 프로젝트</h1>
            <img alt='' src={mainImage1} style={{width:'300px', margin:'10px', border:'5px groove orange'}}/>
            <img alt='' src={mainImage2} style={{width:'300px', margin:'10px', border:'5px groove orange'}}/>
        </div>
    );
};

export default Home;