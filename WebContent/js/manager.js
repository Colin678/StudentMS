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

/**
 * 添加教师按钮Ajax异步请求
 * @returns
 */
function addtea(){
    var id=$("#id1").val();//val()对象取值的方法
    var name=$("#name").val();
    //通过Ajax异步请求TeaServlet部分刷新
    $.ajax({
    	url:"../TeaServlet",
    	type:"post",
    	data:{"name":name,"id":id,"type":"add"},
    	/*data:"name="+name,*/
    	success:function(result,testStatus){
    		if (result == "true") {
				alert("添加成功");
			}else{
				alert("该id已存在请勿重复添加");
			}
    	},
    	error:function(xhr,errorMessage,e){
    		alter("你代码写错了");
    	}
    	    });
}
/**
 * 删除教师
 * @returns
 */
function deltea(){
	var id=$("#id2").val();//val()对象取值的方法
	$.ajax({
    	url:"../TeaServlet",
    	type:"post",
    	data:{"id":id,"type":"del"},
    	/*data:"name="+name,*/
    	success:function(result,testStatus){
    		if (result == "true") {
				alert("状态已标为离职！");
			}else{
				alert("请检查输入id");
			}
    	},
    	error:function(xhr,errorMessage,e){
    		alter("你代码写错了");
    	}
    	    });
}

/**
 * 修改教师
 * @returns
 */
function alttea(){
	//拿出即将要更改的id
	var id=$("#id3").val();//val()对象取值的方法
	//拿出你要更改的id和名字
	var afterid=$("#alterid0").val();
	var aftername=$("#alterid1").val();
	$.ajax({
		url:"../TeaServlet",
    	type:"post",
    	data:{"id":id,"afterid":afterid,"aftername":aftername,"type":"alt"},
    	/*data:"name="+name,*/
    	success:function(result,testStatus){
    		if(result=="true"){
    			alert("修改成功！")
    		}else{
    			alert("修改失败！")
    		}
    	},
    	error:function(xhr,errorMessage,e){
    		alter("你代码写错了");
    	}
	});
    
}

/**
 * 查询教师
 * @returns
 */
function findtea(){
	var id=$("#id4").val();//val()对象取值的方法
	$.ajax({
    	url:"../TeaServlet",
    	type:"post",
    	data:{"id":id,"type":"find"},
    	/*data:"name="+name,*/
    	success:function(result,testStatus){
    		if(result == "false"){
    			alert("输入账号有误");
    		}else{
    			findTeaSon0();
    			findTeaSon1();
    			findTeaSon2();
    		}
    	},
    	error:function(xhr,errorMessage,e){
    		alter("你代码写错了");
    	}
    	    });
	
}
/**
 * 查询的  回调的请求
 */
function findTeaSon0() {
	$("#tip0").load(
			"../QueryTeaIdServlet"
		);
}
function findTeaSon1() {
	$("#tip1").load(
			"../QueryTeaNameServlet"
		);
}
function findTeaSon2() {
	$("#tip2").load(
			"../QueryTeaStateServlet"
		);
}