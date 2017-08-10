var express = require('express');
var router = express.Router();
var data = {
	code: '200',
	msg: '登录失败',
	data: {
	}
};
var data1 = {
	code: '200',
	msg: '登录成功',
	data: {
	    "token":"jdaoajojaojaojoajsoxnhhhhhhhhhhhs"
	}
};
var data2 = {
	code: '400',
	msg: '用户名密码错误',
	data: {
	}
};


router.post('/doLogin/', function(req, res, next) {
    console.log(req.body);
    if(req.body.username=="111"&&req.body.password=="222"){
        res.end(JSON.stringify(data1));
    }else if (req.body.username=="111"&&req.body.password=="33"){
        res.end(JSON.stringify(data2));
    }else{
        res.end(JSON.stringify(data));
    }
});
router.post('/verify/', function(req, res, next) {
    console.log(req.body);
    if(req.body.token==""){
        data.code=400;
        data.msg="token为空";
        res.end(JSON.stringify(data));
    }else if (req.body.token=="jdaoajojaojaojoajsoxnhhhhhhhhhhhs"){
        //重新生成新的token
        //......
        res.end(JSON.stringify(data1));
    }
});

module.exports = router;
