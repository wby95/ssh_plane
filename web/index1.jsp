<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">


  </script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #E0ECFF">
  <table style="padding: 5px" width="100%">
    <tr>
      <td width="50%">
        <img src="${pageContext.request.contextPath}/images/bglogo.png"/>
      </td>
      <td valign="bottom" align="right" width="50%">
        <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.userName }</font>
      </td>
    </tr>
  </table>
</div>
<div region="center">
  <div class="easyui-tabs" fit="true" border="false" id="tabs">
    <div title="首页" data-options="iconCls:'icon-home'">
      <div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎来到购票系统</font></div>
    </div>
  </div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
  <div class="easyui-accordion" data-options="fit:true,border:false">
    <div title="查询机票" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px">
      <a href="javascript:openTab('查询机票','bookingManage.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 150px;">查询机票</a>
    </div>
    <div title="系统管理"  data-options="iconCls:'icon-item'" style="padding:10px">
      <a href="" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
      <a href="" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>

    </div>
  </div>
</div>
<div region="south" style="height: 25px;padding: 5px;" align="center">
  版权所有 zhbit


  <a href="user_list1">user_list1</a>
</div>
</body>
</html>