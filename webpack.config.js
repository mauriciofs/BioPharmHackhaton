/**
 * Created by mauriciofs on 31/08/16.
 */

var path = require('path');

module.exports = {
    entry: [
        "./src/index.js"
    ],
    output: {
        path: __dirname + '/public/',
        filename: "bundle.js"
    },
    module: {
        loaders: [{
            test: /\.js$/,
            loaders: ['react-hot', 'babel'],
            include: path.join(__dirname, 'src')
        }]
    }
};