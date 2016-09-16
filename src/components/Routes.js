/**
 * Created by mauriciofs on 31/08/16.
 */

import React from 'react'
import { Route, IndexRoute, hashHistory} from 'react-router'
import App from './App'
import Home from './Home'
import Login from './Login'

module.exports = (
    <Route path="/" component={App}>
        <IndexRoute component={Home}/>
        <Route path="/home" component={Home}/>
        <Route path="/login" component={Login}/>
    </Route>
)