import React from 'react';
import Menu from './components/Menu';
import { Route, Routes } from 'react-router-dom';
import { About, Food, Home } from './pages'; //index.js에서 export로 다 해놔서 이렇게 나온대

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                {/*<Route path='/' element={<Home/>}/>*/}

                {/**home에 서브메뉴를 만들 고자 할 경우 */}
                <Route path='/home/*' element={<Home/>}/>


                {/*<Route path='/about' element={<About/>}/>*/}

                {/*파라미터를 보내는 경우 : 방법 1 */}
                {/*<Route path='/about/:emp' element={<About/>}/>*/}
                

                {/*파라미터를 보내는 경우 : 방법 2 */}
                <Route path='/about' element={<About/>}>
                    <Route path=':emp' element={<About/>}></Route>
                </Route>
                
                <Route path='/food' element={<Food/>}>
                    <Route path=':food1' element={<Food/>}></Route>
                    <Route path=':food1/:food2' element={<Food/>}></Route>
                </Route>

                {/*그 이외의 매핑주소로 되어있을 경우 */}
                <Route path='*' element={
                    <div>
                        <h1>잘못된 url 주소 입니다.</h1>
                        <br/><br/>
                        <img alt='' src={require(`./images/pin2.jpg`)}></img>
                    </div>
                }/>

            </Routes>
        </div>
    );
};

export default RouterMain;