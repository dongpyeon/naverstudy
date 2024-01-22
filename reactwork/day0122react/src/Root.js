import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import RootMain from './RootMain';


const Root = () => {
    return (
        <div>
            <BrowserRouter>
                <RootMain/>
            </BrowserRouter>
        </div>
    );
};

export default Root;