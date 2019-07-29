<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>请上传文本文件</h1>
<form action="/stu/defaultInfoUpload" enctype="multipart/form-data" method="post">
    <input type="text" name="termName"><br>
    <input type="file" name="multipartFile"><br>
    <input type="submit">
</form>

</body>
</html>