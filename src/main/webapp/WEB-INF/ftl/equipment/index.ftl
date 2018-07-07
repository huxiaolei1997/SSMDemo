<#--这一句是为了让Freemarker识别struts2的标签 -->
<#--<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设备列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="/SSMDemo/static/css/pagination.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <table class="table" style="border: 1px solid #ddd;">
                <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>设备ID</th>
                    <th>描述</th>
                    <th>功能&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-danger batch-delete-equipment" href="javascript:;">删除</a></th>
                </tr>
                </thead>
                <tbody>
                    <#if equipmentPager ??>
                         <#list equipmentPager.dataList as equipment>
                             <tr>
                                 <td><input type="checkbox" class="checkbox-equipment-id" style="width: 15px;" value="${equipment.id}"></td>
                                 <td>${equipment.id}</td>
                                 <td>${equipment.code}</td>
                                 <td>${equipment.desc}</td>
                                 <td><a class="btn btn-primary" href="javascript:location.href='equipment/${equipment.id}/edit';">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-danger" href="javascript:location.href='deleteEquipmentById?equipment_id=${equipment.id}';">删除</a></td>
                             </tr>
                         </#list>
                    </#if>
                </tbody>
            </table>
        </div>
        <div class="col-lg-6 col-lg-offset-3">
            <div class="m-style M-box"></div>
            <div>
                <form id="pager" method="post" action="showEquipment?page_num=1">

                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="/SSMDemo/static/js/jquery.pagination.js"></script>
<script type="text/javascript">
    $(function() {
        $('.M-box').pagination({
            pageCount: ${equipmentPager.total_page},
            current: ${equipmentPager.current_page},
            callback: function (api) {
                // 当前页号
                var current_page = api.getCurrent();
                $("#pager").attr("action", "showEquipment?page_num=" + current_page);
                console.log(current_page);
                $("#pager").submit();
            }
        });

        // 删除单个设备
        $(".batch-delete-equipment").click(function() {
            var batch_equipment_id = "";
            $(".checkbox-equipment-id:checked").each(function() {
                batch_equipment_id += $(this).val() + " ";
            });
            console.log(batch_equipment_id);
            $.ajax({
                url: "deleteEquipmentBatch",
                type: "POST",
                data: {
                    batch_equipment_id: batch_equipment_id
                },
                dataType: "json",
                success: function (response) {
                    console.log(response);
                    location.reload();
                },
                error: function() {

                }
            });
        });
    });

</script>
</body>
</html>
