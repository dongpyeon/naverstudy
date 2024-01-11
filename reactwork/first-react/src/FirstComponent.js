import React from "react";
import './MyStyle.css';
import s5 from './pam.jpg'
import s10 from './파마니.jpg'

let FirstComponent=()=>{

    return (
        <div className="box">
            <h3>FirstComponent 컴포넌트!</h3>
            <h6>public 의 이미지 나타내기</h6>
            {/*public 이미지는 직접 경로로 지정해야함 - 권장안함 */}
            <img alt="" src="팜하니.jpg" style={{border: '3px solid pink',width:'100px'}}/>
            
            <h6>src 의 이미지 나타내기</h6>
            <img alt="" src={s5} style={{border: '3px solid pink',width:'100px'}}/>
            
            
            <img alt="" src={s10} style={{border: '3px solid pink',width:'100px'}}/>
     
        
        </div>

    )
}

export default FirstComponent;