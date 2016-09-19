/**
 * Created by mauriciofs on 17/09/16.
 */

import React from 'react';
import Session from '../modules/Session';

export default React.createClass({
    getInitialState: function() {
        return {logged: Session.getSession() ? true : false};
    },
    render(){
        return (
            <div>
                <nav className="Header" class="navbar navbar-custom navbar-fixed-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                                Menu <i class="fa fa-bars"></i>
                            </button>
                            <a class="navbar-brand page-scroll" href="#page-top"><i class="fa fa-play-circle"></i> <span class="light">Start</span> Bootstrap</a>
                        </div>

                        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                            <ul class="nav navbar-nav">
                                <li class="hidden"><a href="#page-top"></a></li>
                                <li><a class="page-scroll" href="#about">About</a></li>
                                <li><a class="page-scroll" href="#download">Download</a></li>
                                <li><a class="page-scroll" href="#contact">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        );
    }
})