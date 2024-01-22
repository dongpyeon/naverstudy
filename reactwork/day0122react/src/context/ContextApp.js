import React, { useState } from 'react';
import { ThemaContext } from './ThemaContext';
import Page from './Page';
import './ContextStyle.css';
import { UserContext } from './UserContext';

const ContextApp = () => {
    const [isDark, setIsDark] = useState(false);
    return (
        <div>
            {
                /**이 경우는 page를 거쳐서 head,content,footer 
                 * 컴포넌트로 각 값이나 이벤트를 전달하여만 한다 */
            }
            {/* <page isDark={isDark} setIsDark={setIsDark}/> */}
            <UserContext.Provider value={"미쳐버린설석현"}>
                <ThemaContext.Provider value={{ isDark, setIsDark, doll:'03.png' }}>
                    <Page />
                </ThemaContext.Provider>
            </UserContext.Provider>
        </div>
    );
};

export default ContextApp;