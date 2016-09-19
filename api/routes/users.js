'use strict';

var express = require('express');
var router = express.Router();
var shortid = require('shortid');
var moment = require('moment');

const Users = require('../models/Users');

/* GET users listing. */
router.get('/:userId', function(req, res) {
  console.log(req.params);

  res.send(
    [
        {
          id: 1,
          name: "Pill",
          created_at: moment().format('YYYY-MM-DD HH:mm:ss')
        },
        {
          id: 2,
          name: "Doctor 1",
          created_at: moment().format('YYYY-MM-DD HH:mm:ss')
        }
    ]
  );
});

router.post('/', function(req, res, next) {
  console.log(req.body);
  let user = new Users({
    name: req.body.name,
    email: req.body.email,
    token: "",
    tokenExpire: "",
    id: shortid.generate()
  });

  user.save(function(err, user) {
    if(err) {
      console.error(err);
      return next(err);
    }

    res.status(200).json({ message: "Successful" });
    next();
  });
});


module.exports = router;
