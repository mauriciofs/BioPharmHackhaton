/**
 * Created by mauriciofs on 31/08/16.
 */

import React from 'react'
import Session from '../modules/Session'
import { hashHistory } from 'react-router'

export default React.createClass({
    render() {
        return (
            <div>
                <h1>Charlie's Life</h1>
                {this.props.children}
            </div>
        )
    },
    componentWillMount(){
        if(Session.getSession() === false){
            hashHistory.push('/login')
        }
    }
})