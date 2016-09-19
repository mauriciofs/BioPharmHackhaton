/**
 * Created by mauriciofs on 31/08/16.
 */

import cookie from 'react-cookie';

class Session {
    getSession(){
        //console.log(cookie.load('userId'));
        if(cookie.load('userId')){
            return true;
        }
        return false;
    }

    validateUser(user, pass){
        if(user !== 'admin') return false;

        hash.update('some data to hash');
        cookie.save('userId', 1, { path: '/' });
        /*fs.open(`${sessionStorage}/${hash.digest('hex')}`, 'a+', (err, fd) => {
            
        });*/
        return true;
    }
}

export default new Session();