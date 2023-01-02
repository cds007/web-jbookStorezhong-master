
function checkUsername(userid){
    if (userid === null ||userid === '' ||userid.length === 0){
        return '用户名不能为空';
    }
    if (userid.length <= 5){
        return '用户名长度必须大于5';
    }
    return '';
}
function checkIsNull(userid){
    if (userid === null ||userid === '' ||userid.length === 0){
        return '该位置不能为空';
    }
}
function checkNull(userid) {
    if (userid === null ||userid === '' ||userid.length === 0){
        return '密码不能为空';
    }
}


$(function(){
    $('#password').on('blur',function(){
        var password = $(this).val();
        var validateMsg = checkNull( password);
        $('#feedback').text(validateMsg);
    });
    $('#password2').on('blur',function(){
        var password = $(this).val();
        var validateMsg = checkNull( password);
        $('#feedback').text(validateMsg);
    });
    $('#password3').on('blur',function(){
        var password = $(this).val();
        var validateMsg = checkNull( password);
        $('#feedback').text(validateMsg);
    });
    $('#userid').on('blur',function(){
        var userid =$(this).val();
        var validateMsg = checkUsername(userid);
        if (validateMsg === ''){
            $('#feedback').text('');
            $.ajax({
                type : 'GET',
                url  :  'http://localhost:8080/web_jpetStore_war_exploded/usernameIsExistServlet?userid='+userid,
                success : function (data){
                    if(data === 'Exist'){
                        $('#feedback').text('用户名已存在');
                    }
                },
                error : function (errorMsg){
                    if(errorMsg === 'Not Exist'){
                        $('#feedback').text('用户名不存在');
                    }
                }
            });
        }
        else {
            $('#feedback').text(validateMsg);
        }
    });
});
