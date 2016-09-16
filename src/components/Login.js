/**
 * Created by mauriciofs on 31/08/16.
 */

import React from 'react'
import Session from '../modules/Session'
import { hashHistory } from 'react-router'

export default React.createClass({
    handleSubmit(event){
        //Prevent default event
        event.preventDefault();
        var user = event.target[0].value;
        var pass = event.target[1].value;
        
        if(Session.validateUser(user, pass)){
            hashHistory.push('/home');
        }
    },
    render(){
        return (
            <div>
                <h3>Please, login:</h3>
                <form onSubmit={this.handleSubmit} action="#">
                    <input type="text" name="user" placeholder="User"/><br/>
                    <input type="password" name="password" placeholder="Password"/><br/>
                    <input type="submit" value="Login"/>
                </form>
            </div>
        )
    }
})