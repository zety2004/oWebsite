<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="pagerForm" method="post" action="/homePage/queryFeedBack">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="/homePage/queryFeedBack" method="post" onreset="$(this).find('select.combox').comboxReset()">
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
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit" >检索</button></div></div></li>
					<!--<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>-->
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete" href="/homePage/deleteFeedBackById?id={sid_user}"  target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
		<tr>
			<th width="10%">主键</th>
			<th width="10%">用户名</th>
			<th width="10%">用户电话</th>
			<th width="60%">用户描述</th>
			<th width="10%">生成时间</th>
		</tr>
		</thead>
		<tbody id="feedBack">
		<c:forEach items="${list}" var ="obj">
			<tr target="sid_user" rel="${obj.id}"><td>${obj.id}</td><td>${obj.userName}</td><td>${obj.userPhone}</td><td>${obj.des}</td><td>${obj.createTime}</td></tr>
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