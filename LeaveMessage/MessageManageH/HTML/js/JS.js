function TMouseover() {
    this.style.borderColor='black';
    this.style.backgroundColor='red'
}
//留言
function submitText(text) {
    //获取留言信息：textarea中的value
    var data=document.getElementById(text).value;
    //获取当前时间
    var time =new Date().getTime();
    //将时间戳作为键值，textarea的value值作为键值的内容保存在本地数据库
    localStorage.setItem(time,data);
    //保存成功后提示成功
    alert("留言成功");
    //设置loadStorage函数的传参（ID值）
    loadMessage('msg');
}
function loadMessage(id) {
    var result = '<table>';
    //遍历本地数据所有内容
    for(var i = 0; i < localStorage.length; i++) {
        //获取每一条新增的键值
        var kes = localStorage.key(i);
        //获取新增键值的内容
        var value = localStorage.getItem(kes);
        //获取时间对象
        var date = new Date();
        //将时间戳转化为正常时间 Mon Jun 19 1972 11:12:44 GMT+0800 (中国标准时间) 的格式
        date.setTime(kes);
        //将转化后的内容变成字符串
        var datestr = date.toGMTString();
        //将所有新增内容添加到result变量中
        result += '<tr><td>' + value + '</td><td>' + datestr + '</td></tr>'
    }
    result += '</table>';
    var target = document.getElementById(id);
    //将所有内容添加到元素中显示
    target.innerHTML = result;

}

function clearText() {
    //清除本地储存所有内容
    localStorage.clear();
    alert("清除完毕");
}