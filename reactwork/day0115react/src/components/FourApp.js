import React from 'react';
import img1 from '../iamges/1.jpg';
import img2 from '../iamges/2.jpg';
import img3 from '../iamges/3.jpg';
import img4 from '../iamges/4.jpg';
import '../MyStyle.css';

function FourApp(props) {
    //4rodml import 된 이미지를 배열에 저장
    const myImage = [img1, img2, img3, img4];
    const data = [
        { "name": "설석현", "addr": "지옥", "hp": "010-1234-5678", "photo": "1" },
        { "name": "이재영", "addr": "비트캠프", "hp": "010-7895-5548", "photo": "2" },
        { "name": "팜하니", "addr": "뉴진스", "hp": "010-0485-1234", "photo": "3" },
        { "name": "장원영", "addr": "아이브", "hp": "010-1132-5765", "photo": "4" },
    ];

    return (
        <div>
            <h3 className='alert alert-success'>FourApp-map 으로 이미지배열출력</h3>
            {
                myImage.map((img, idx) => (<img alt='' src={img} width={200} />))
            }
            <hr />
            {
                data.map((ele, i) => (
                    <div className='box'>
                        <h5>이름: {ele.name}</h5>
                        <h5>주소: {ele.addr}</h5>
                        <h5>주소: {ele.hp}</h5>
                        <img alt='' src={require(`../iamges/${ele.photo}.jpg`)} width='120' />
                    </div>
                ))
            }
            <br />
            <table className='table table-bordered' style={{ width: '400px' }}>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>사진</th>
                        <th>이름</th>
                        <th>핸드폰</th>
                        <th>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data.map((ele, i) => (
                            <tr>
                                <td>{i + 1}</td>
                                <td><img alt='' src={require(`../iamges/${ele.photo}.jpg`)} width={50} /></td>
                                <td>{ele.name}</td>
                                <td>{ele.hp}</td>
                                <td>{ele.addr}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}


export default FourApp;