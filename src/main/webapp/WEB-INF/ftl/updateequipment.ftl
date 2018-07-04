<#--这一句是为了让Freemarker识别struts2的标签 -->
<#--<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <form role="form">
                    <div class="form-group">
                        <label for="name">设备ID</label>
                        <input type="text" class="form-control" id="code"
                               value="${equipment.code}" disabled="disabled">
                    </div>
                    <div class="form-group">
                        <label for="name">设备描述</label>
                        <textarea class="form-control" id="desc">${equipment.desc}</textarea>
                    </div>
                    <input type="hidden" value="${equipment.id}" name="id"/>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
