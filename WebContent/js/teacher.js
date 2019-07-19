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
 * 添加学生按钮Ajax异步请求
 * @returns
 */
function addstu(){
	//拿到要添加的学生id和姓名
    var id=$("#id1").val();//val()对象取值的方法
    var name=$("#name").val();
    
    //通过Ajax异步请求StuServlet部分刷新
    $.ajax({
    	url:"../StuServlet",
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
    		alert("你代码写错了");
    	}
    	    });
}


/**
 * 删除学生按钮 异步请求
 * @returns
 */
function delstu() {
	var id=$("#id2").val();
	$.ajax({
		url:"../StuServlet",
    	type:"post",
    	data:{"id":id,"type":"del"},
    	/*data:"name="+name,*/
    	success:function(result,testStatus){
    		if (result == "true") {
				alert("已删除");
			}else{
				alert("请输入正确的id");
			}
    	},
    	error:function(xhr,errorMessage,e){
    		alert("你代码写错了");
    	}
	});
}
/**
 * 修改学生信息  根据id
 * @returns
 */
 function altstu() {
	var id =$("#id3").val();
	var afterid =$("#alterid0").val();
	var aftername =$("#alterid1").val();
	var afterstate =$("#alterid2").val();
	if((afterstate!="在读")&&(afterstate!="毕业")&&(afterstate!="退学")){
		alert("请输入正确的格式");
	}else{
		$.ajax({
			url:"../StuServlet",
	    	type:"post",
	    	data:{"id":id,"afterid":afterid,"aftername":aftername,"afterstate":afterstate,"type":"alt"},
	    	/*data:"name="+name,*/
	    	success:function(result,testStatus){
	    		if (result == "t") {
					alert("修改成功")
				}else{
					alert("修改失败")
				}
	    	},
	    	error:function(xhr,errorMessage,e){
	    		alert("你代码写错了");
	    	}
		});
	}
 }
/**
 * 查询三种类型的学生
 * @returns
 */
function findstu() {
	//$("#tableinfo").empty();
	var state = $("#id4").val();
	if((state!="在读")&&(state!="毕业")&&(state!="退学")){
		alert("请输入正确的格式");
	}else{
		$.ajax({
			url:"../StuServlet",
			type:"post",
			data:{"state":state,"type":"find"},
			//data:"state="+state
			/*data:"name="+name,*/
			//dataType:"JSON",
			success:function(result,testStatus){
				alert(result);
				//alert(result.data[0].name)
				/*var data=result.data;
				alert(data);
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var name = data[i].name;
				}*/
				/*$(`
						<span></span>
						`).appendTo("#tableinfo");*/
			},
			error:function(xhr,errorMessage,e){
				alert("本次请求出错");
			}
		});
	}
}
/**
 * 根据id   为学生添加语数英成绩
 * @returns
 */
function subach() {
	var id =$("#id5").val();
	var chinese=$("#chinese").val();
	var math=$("#math").val();
	var english=$("#english").val();
	if((0<chinese<100)&&(0<chinese<100)&&(0<chinese<100)){
		$.ajax({
			url:"../AchievementServlet",
			type:"post",
			data:{"id":id,"chinese":chinese,"math":math,"english":english,"type":"add1"},
			success:function(result,testStatus){
				showStuName1();
				if(result=="t"){
					alert("添加成功");
				}else{
					alert("添加失败");
				}
			},
			error:function(xhr,errorMessage,e){
				alert("你代码写错了");
			}
		});
	}else{
		alert("输入错误");
		
	}
	
}

/**
 * 根据id   为学生修改语数英成绩
 * @returns
 */
function altach() {
	var id =$("#id6").val();
	var chinese=$("#chinese1").val();
	var math=$("#math1").val();
	var english=$("#english1").val();
	if((0<chinese<100)&&(0<chinese<100)&&(0<chinese<100)){
		$.ajax({
			url:"../AchievementServlet",
			type:"post",
			data:{"id":id,"chinese":chinese,"math":math,"english":english,"type":"alt1"},
			success:function(result,testStatus){
				showStuName2();
				if(result=="t"){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
			},
			error:function(xhr,errorMessage,e){
				alert("你代码写错了");
			}
		});
	}else{
		alert("输入错误");
	}
}

function showStuName1() {
	$("#sname1").load(
			"../QueryStuName"
		);
}
function showStuName2() {
	$("#sname2").load(
			"../QueryStuName"
		);
}