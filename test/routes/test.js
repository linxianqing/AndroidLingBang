//// 增加url 依赖
var urllib = require('url');
var express = require('express');
var router = express.Router();
// 初始数据
var data = {
	status: '100',
	msg: '操作成功',
	data: {
		userId: '123456',
		userName: 'hgdqstudio',
		blog: 'http://hgdqstudio.online'
	}
};
// get请求
router.get('/', function (req, res, next) {
	var params = urllib.parse(req.url, true);
	var query2 = params.query;
	// 打印get请求中的接口参数
	console.log(query2);
	res.end(JSON.stringify(data));
});

module.exports = router;
