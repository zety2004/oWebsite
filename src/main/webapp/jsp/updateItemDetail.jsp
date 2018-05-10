<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script >
    function savePic(){
        var formData = new FormData($("form[name='opItemDetail']")[0]);
        var ajaxUrl = "/homePage/upload";
        $.ajax({
            type: "POST",
            //dataType: "text",
            data: formData,
            url: ajaxUrl,
            async: false,
            cache: false,
            contentType: false,
            dataType:"json",
            processData: false,
            success: function (data) {
                $("form[name='opItemDetail'] input[name='pic']").val(data.msg);
            },
            error: function(data) {
                alert("error:"+data.responseText);
            }
        });
        return false;
    }
</script>

<div class="pageContent">
    <form name="opItemDetail" method="post" action="/homePage/addOrUpdateItemDetail" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>主 键:</label>
                <input name="id" type="text" size="30" value="${itemDetail.id}" readonly="readonly"/>
            </p>
            <p>
                <label>栏目名称:</label>
                <input name="itemDetailName" value="${itemDetail.itemDetailName}" class="required" type="text" size="30" alt="请输入栏目名"/>
            </p>

            <p>
                <label>序列编号:</label>
                <input name="orderLevel" value="${itemDetail.orderLevel}" class="digits" type="text" size="30" alt="请输入数字"/>
            </p>
            <p>
                <label>来源:</label>
                <input name="source" value="${itemDetail.source}" class="required" type="text" size="30"/>
            </p>
            <p style="width: 500px" >
            <label>图片:</label><input id="temp" type="file" name="file"/><button type="button" onclick="savePic()">提交</button>
            </p>
            <p>
                <input style="width: 500px;" name = "pic" value="${itemDetail.pic}">
            </p>
            <p>
            </p>
            <p>
            </p>
            <p>
                <label>描述：</label>
                <textarea class="editor" name="des"  rows="30" cols="240"  upimgurl="/homePage/upload" upimgext="jpg,jpeg,gif,png" style="display: none;">${itemDetail.des}</textarea>
            </p>
            <p><input name="itemId" value="${itemDetail.itemId}" type="hidden"></p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
