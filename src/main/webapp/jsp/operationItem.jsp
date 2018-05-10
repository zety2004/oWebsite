<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="/homePage/queryItem">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}"/>
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="numPerPage" value="${model.numPerPage}"/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="/homePage/queryItem" method="post"
          onreset="$(this).find('select.combox').comboxReset()">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <!--<td class="dateRange">
                        建档日期:
                        <input name="startDate" class="date readonly" readonly="readonly" type="text" value="">
                        <span class="limit">-</span>
                        <input name="endDate" class="date readonly" readonly="readonly" type="text" value="">
                    </td>-->
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <!--<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>-->
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">检索</button>
                            </div>
                        </div>
                    </li>
                    <!--<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>-->
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="/homePage/queryItemById?method=add" rel="addItem" target="navTab"><span>添加</span></a></li>
            <li><a class="delete" href="/homePage/deleteItem?id={sid_user}" target="ajaxTodo"
                   title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="/homePage/queryItemById?method=update&id={sid_user}" rel="updataItem"
                   target="navTab"><span>修改</span></a></li>
            <li><a class="edit" href="/homePage/queryItemDetail?id={sid_user}" rel="opItemDetail"
                   target="navTab"><span>管理明细</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="25%">序号</th>
            <th width="25%">栏目名</th>
            <th width="25%">序列</th>
            <th>是否头部显示</th>
        </tr>
        </thead>
        <tbody id="itemData">
        <c:forEach items="${list}" var="obj" varStatus="temp">
            <tr target="sid_user" rel="${obj.id}">
                <td>${temp.index+1}</td>
                <td>${obj.itemName}</td>
                <td>${obj.orderLev}</td>
                <td>${obj.isTop==1?'是':'否'}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="150">150</option>
                <option value="200">200</option>
                <option value="250">250</option>
            </select>
            <span>条，共${totalCount}条</span>
        </div>
        <div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10"
             currentPage="1"></div>
    </div>
</div>