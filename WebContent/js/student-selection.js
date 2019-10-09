$(function(){
	
	$('#sa').change(function(){
		 var xz = $(this).prop("checked");//判断全选按钮的选中状态
	        var ck = $('input[name=selid]:checkbox').prop("checked",xz); 
	})
	$('#selectall').change(function(){
		if($(this).prop('checked')){
			$('input[name=courseid]:checkbox').prop('checked',true);
		}else{
			$('input[name=courseid]:checkbox').prop('checked',false);
		}
	})
})


