/**
 * Created by mauriciofs on 31/08/16.
 */

import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, hashHistory, IndexRoute } from 'react-router'
import Routes from './components/Routes'

ReactDOM.render(
    <Router routes={Routes} history={hashHistory}/>,
    document.getElementById('content')
);