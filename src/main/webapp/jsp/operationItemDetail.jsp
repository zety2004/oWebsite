<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="pagerForm" method="post" action="operationItem.jsp">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" id="addItemDetail" href="/homePage/queryItemDetailById?method=add&itemId=${itemId}" rel="addItemDetail" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="/homePage/deleteItemDetail?id={sid_user}"  target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="/homePage/queryItemDetailById?method=update&id={sid_user}" rel="updataItemDetail" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
		<tr>
			<th width="14.2%">序号</th>
			<th width="14.2%">头部</th>
			<th width="14.2%">序列</th>
			<th width="14.2%">描述</th>
			<th width="14.2%">图片</th>
			<th width="14.2%">来源</th>
			<th width="14.2%">创建时间</th>
		</tr>
		</thead>
		<tbody id="itemDataDetail">
		<c:forEach items="${list}" var ="obj" varStatus="temp">
			<tr target="sid_user" rel="${obj.id}"><td>${temp.index+1}</td><td>${obj.itemDetailName}</td><td>${obj.orderLevel}</td><td>${obj.des}</td><td>${obj.pic}</td><td>${obj.source}</td><td>${obj.createTime}</td></tr>
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
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>
	</div>
</div>