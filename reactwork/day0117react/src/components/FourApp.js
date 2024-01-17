import { Alert } from '@mui/material';
import React from 'react';
import FourGuestForm from './FourGuestForm';

function FourApp(props) {
    return (
        <div>
            <Alert severity='info' variant='filled'>
                <h3>FourApp-guest DB</h3>               
            </Alert>
              <FourGuestForm/>
       </div>
            );
}

export default FourApp;