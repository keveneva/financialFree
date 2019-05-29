<!DOCTYPE html>
<style type="text/css">
    *{
        margin: 0;
        padding: 0;
        background-color: #EAEAEA;
    }
    div{
        width: 200px;
        height: 200px;
        background-color: #1E90FF;
    }
</style>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>首页</title>
</head>
<body>
<br/><br/>
<button onclick="download()">下载模板</button>
<br/><br/>
<form id="uploadForm" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file" />
</form>
<br/>
<button id="upload">上传文件</button>




<script>
    function download() {
        var url = "http://localhost:8086/sys/download";
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            success: function(msg) {
                alert("下载成功，文件在d:temp,名称为："+msg.fileName);
                console.log(msg)
            },
            error: function() {
                console.log("error")
            }
        })
    }
    $(function () {
        $("#upload").click(function () {
            var formData = new FormData($('#uploadForm')[0]);
            $.ajax({
                type: 'post',
                url: "http://localhost:8086/sys/upload",
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
            }).success(function () {
                alert("上传成功");
            }).error(function () {
                alert("上传失败");
            });
        });
    });

</script>
</body>
</html>
