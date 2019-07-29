<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>请上传文本文件</h1>
<form action="/stu/updateInfo" enctype="multipart/form-data" method="post">
    姓名：<input type="text" name="stuName"><br>
    照片：<input type="pic" name="picFile"><br>
    身份证：<input type="text" name="idNo"><br>
    手机号：<input type="text" name="mobile"><br>
    学校：<input type="text" name="schllol"><br>
    学位：<input type="radio" name="master" value="0" checked>学士
    <input type="radio" name="master" value="1">准硕士
    <input type="radio" name="master" value="2">硕士<br>
    毕业年份：<input type="text" name="graduateYear"><br>
    生日：<input type="text" name="birthday"><br>
    性别：<input type="radio" name="gender" value="male" checked>男<input type="radio" name="gender" value="female">女<br>
    <input type="submit">
</form>

</body>
</html>