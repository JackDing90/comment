$(function() {
	common.showMessage($("#message").val());
});

function add() {
	
	$.ajax({ 
	 url: "add", 
	 type:'POST', 
     data:$('#mainForm').serialize(),
	 success: function(){
		 alert("success");
	 }
    });	
}

function check() {
	// TODO 需要添加表单验证
	return true;
}

function goback() {
	location.href = $('#basePath').val() + '/ad';
}