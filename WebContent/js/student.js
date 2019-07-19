/**
 * 此方法用于点击左边摸个li展现对应的div具体实现
 * @param obj
 * @returns
 */
function dj(obj) {
	var divarr=document.getElementsByName("xiao");
	for(var i=0;i<divarr.length;i++){
		divarr[i].className="hide";
		if(i==obj){
			divarr[obj].className="show";
		}
	}
}
function showach() {
	 $.ajax({
	    	url:"../ShowMyachServlet",
	    	type:"post",
	    	dateType:"JSON",
	    	success:function(result,testStatus){
	    		var info =JSON.parse(result)
	    		$("#showc").html(info.chinese)
	    		$("#showm").html(info.math)
	    		$("#showe").html(info.english)
	    		$("#showa").html(info.avg)
	    		$("#shows").html(info.sum)
	    	},
	    	error:function(xhr,errorMessage,e){
	    		alter("你代码写错了");
	    		}
	    	});
}
/**
 * 修改密码的Ajax
 * @returns
 */
function repwd() {
	var pwd0=$("#newpwd0").val();
	var pwd1=$("#newpwd1").val();
	if(pwd0!=pwd1){
		alert("两次输入的密码不一致");
	}else{
		$.ajax({
			url:"../ReMyPwdServley",
			type:"post",
			data:"pwd="+pwd0,
			success:function(result,testStatus){
				if(result=="t"){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
	    	},
	    	error:function(xhr,errorMessage,e){
	    		alter("你代码写错了");
	    		}
		});
	}
}
