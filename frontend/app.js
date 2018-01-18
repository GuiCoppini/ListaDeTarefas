var express = require('express');
var app = express();
var path = require('path');

app.set('scripts', __dirname);

app.use(function(req, res, next){
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "*");
    next();
});

app.use(express.static(__dirname));

app.get('/', function (req, res) {
  res.sendFile(path.join(__dirname+'/index.html'));
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});