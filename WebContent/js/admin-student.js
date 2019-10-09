$(function(){
	$('#form-div').hide();
});
function add(){
	$('#form-div').show();
	$("#table").hide();
	$('#class-title').html("学生信息");
}

function edit(stuid,stunum,stuname,password,classid,classname){
	$('input[name=stuid]').val(stuid);
	$('input[name=stunum]').val(stunum);
	$('input[name=stuname]').val(stuname);
	$('input[name=password]').val(password);
	
	$('#classid').val(classid);
	$('#form-div').show();
	$("#table").hide();
}














