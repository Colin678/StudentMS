function reloadImage() {
		$("img").attr("src","img.jsp?t="+(new Date().getTime()));
	}
	
		$(document).ready(function(){
			$("#checkcodeid").blur(function() {
				var checkcodeid=$("#checkcodeid").val();
				//校验 文本框输入的值 发送到服务端
				$.post(
					"../UserServlet",//服务端地址		
					"checkcodeid="+checkcodeid,
					function(result){
						
					}
				);
			});
		});