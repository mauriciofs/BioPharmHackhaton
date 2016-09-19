/**
 * Created by mauriciofs on 17/09/16.
 */
'use strict';

var express = require('express');
var router = express.Router();
var shortId = require('shortid');
var moment = require('moment');
const Users = require('../models/Users');

/* GET home page. */
router.get('/:userId', function(req, res) {
    console.log(req.params);

    Users.findOne({ 'id': req.params.userId }, 'id token tokenExpire', function (err, user) {
        if (err || !user){
            return res.status(404).send({error: 'User not found'});
        };

        console.log(user);
        //Generate access token and set expire date
        var token = shortId.generate();
        let response = {token: token};

        console.log('Response: ', response);
        res.send(response);
    });
});

module.exports = router;
