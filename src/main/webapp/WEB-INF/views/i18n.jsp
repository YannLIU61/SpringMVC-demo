<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I18n</title>
</head>
<body>
	<!-- 关于国际化:
	1. 在页面上根据浏览器语言设置对文本,时间,数字进行本地化处理
	2.可以在bean中获取国际化资源文件Locale对应的消息
	3.可以通过超链接切换Locale,而不在依赖浏览器语言设置情况
	解决方案:
	1.使用JSTL 的fmt标签
	2.在bean中注入ResourceBundleMessageSource的示例,使用其对应的getMessage方法
	3.配置LocalResolver和LocaleChangeInterceptor
	 -->
	 <fmt:message key="i18n.name"></fmt:message>
	 <br><br>
	 <a href="i18n2">I18N2 PAGE</a>
	 <br><br>
	 <a href="i18n2?locale=zh_CN">中文</a>
	  <br><br>
	 <a href="i18n2?locale=en_US">英文</a>
	 
	 
</body>
</html>