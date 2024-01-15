import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SevenApp from './SevenApp';
import SixApp from './SixApp';
import EightApp from './EightApp';

function MainApp(props) {
    const [index,setIndex]=useState(1);

    const onChangeApp=(e)=>{
        setIndex(Number(e.target.value));
    }
    return (
        <div style={{margin:'30px'}}>
            <label>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={1} defaultChecked/>OneApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={2}/>TwoApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={3}/>ThreeApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={4}/>FourApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={5}/>FiveApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={6}/>SixApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={7}/>SevenApp
            </label>
            <label style={{marginLeft:'20px'}}>
                <input type='radio' name='myapp' onClick={onChangeApp}
                    defaultValue={8}/>EightApp
            </label>



            <hr/>
            {
                index===1?<OneApp/>:
                index===2?<TwoApp/>:
                index===3?<ThreeApp/>:
                index===4?<FourApp/>:
                index===5?<FiveApp/>:
                index===6?<SixApp/>:
                index===7?<SevenApp/>:
                <EightApp/>
            }
        </div>
    );
}

export default MainApp;