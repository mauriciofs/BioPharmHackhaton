/**
 * Created by mauriciofs on 31/08/16.
 */

//const fs = require('fs');
//const crypto = require('crypto');

import fs from 'fs';
import crypto from 'crypto'

const hash = crypto.createHash('sha256');
const sessionStorage = '../session/';

class Session {
    getSession(){
        return false;
    }

    validateUser(user, pass){
        if(user !== 'admin') return false;

        hash.update('some data to hash');
        fs.open(`${sessionStorage}/${hash.digest('hex')}`, 'a+', (err, fd) => {
            
        });
        return true;
    }
}

export default new Session();