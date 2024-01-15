import React from 'react';

function ThreeApp(props) {
    const names=['리액트','스프링부트','뷰','설석구','리재영']
    
    //방법1
    //li의 key 값을 유니크한 값으로 넣어야 콘솔에 오류가 없음
    const nameList=names.map((irum,i)=>(<li key={i}>{irum}</li>));

    return (
        <div>
            <h3 className='alert alert-success'>ThreeApp-map 반복문</h3>
            {nameList}
            <hr/>
            {/**직접 return 문 안에서 반복해서 출력하는 경우 */}
            {
                names.map((irum,i)=>(<h6 key={i}>{i}:{irum}</h6>))
            }
            <hr/>
            {/**배열이 아닌 특정 숫자 범위로 출력하고자 할 경우 */}
            {
                [...new Array(10)].map((a,i)=><h5 key={i}>{i}</h5>)
            }
            <hr/>
            {/**배열이 아닌 특정 숫자 범위로 출력하고자 할 경우 */}
            {
                [...new Array(6)].map((a,i)=>
                <img key={i} alt='' src={require(`../팜${i+1}.jpg`)} width={200} height={200}/>)
            }
        </div>
    );
}

export default ThreeApp;