<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="pageContent">
    <form name="opItem" method="post" action="/homePage/addOrUpdateItem" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>主 键：</label>
                <input name="id" type="text" value="${itemContent.id}" size="30" readonly="readonly"/>
            </p>
            <p>
                <label>栏目名称：</label>
                <input name="itemName" value="${itemContent.itemName}" class="required" type="text" size="30" alt="请输入栏目名"/>
            </p>

            <p>
                <label>序列编号：</label>
                <input name="orderLev" value="${itemContent.orderLev}" class="digits" type="text" size="30" alt="请输入数字"/>
            </p>
            <p>
                <label>是否顶部显示：</label>
                <select name="isTop"  class="required combox" >
                    <option value="">请选择</option>
                    <option value="1" ${itemContent.isTop==1?'selected':''}>是</option>
                    <option value="0" ${itemContent.isTop==0?'selected':''}>否</option>
                </select>
            </p>


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
