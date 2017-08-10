//// 增加url 依赖
var urllib = require('url');
var express = require('express');
var router = express.Router();
config = require("../json/test.json");
//var MongoClient = require('mongodb').MongoClient;
//var DB_CONN_STR = 'mongodb://localhost:27017/zhaomenghuan';

// Use connect method to connect to the server
//MongoClient.connect(DB_CONN_STR, function(err, db) {
//    console.log("Connected successfully to server");
////    db.close();
//});

router.get('/', function(req, res){

    res.end(JSON.stringify(config));
});
module.exports = router;
