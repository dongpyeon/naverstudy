import React, { useRef, useState } from 'react';
import cate from '../data/CateData.json';

function SixApp(props) {
    const navData=cate.navData;
    const CateData=cate.categoryData;

    //이미지에 적용할 ref 변수 선언
    const mainPhotoRef=useRef(null);
    const [photo,setPhoto]=useState('');
    return (
        <div>
            <h3 className='alert alert-success'>SixApp-json 데이타 출력</h3>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        navData.map((item,i)=>
                        <li key={i}>
                            <div>
                                <img alt='' src={item.img} className='imgcategory'
                                onClick={(e)=>
                                mainPhotoRef.current.src=e.target.src}></img>
                            </div>
                            <div>{item.title}</div>
                        </li>)
                    }
                </ul>
            </div>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        CateData.map((item,i)=>
                        <li key={i}>
                            <div>
                                <img alt='' src={item.img} className='imgcategory'
                                onClick={(e)=>setPhoto(e.target.src)}></img>
                            </div>
                            <div>{item.title}</div>
                        </li>)
                    }
                </ul>
            </div>
            {/**아이콘 클릭시 작은 이미지를 가져와서 출력할 메인 이미지 */}
            <div>
                <img alt='' src={photo} style={{width:'300px', height:'300px', border:'5px inset gray', margin:'50px 300px'}}
                ref={mainPhotoRef}/>
            </div>
        </div>
    );
}

export default SixApp;