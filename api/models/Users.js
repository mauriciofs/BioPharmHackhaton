/**
 * Created by mauriciofs on 17/09/16.
 */

const mongoose = require('mongoose'), Schema = mongoose.Schema;

const UsersSchema = new Schema({
    name: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true
    },
    token: {
        type: String,
        required: false
    },
    tokenExpire: {
        type:Date,
        required: false
    },
    id: {
        type: String,
        required: true
    },
    secretKey: {
        type: String,
        required: true
    }
}, {
    timestamps: true
});

module.exports = mongoose.model('Users', UsersSchema);