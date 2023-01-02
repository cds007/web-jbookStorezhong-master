$(function (){
    $('#keyword').on('keyup',function (){
        var keyword=$(this).val();
        if(keyword!==null&&keyword!==''&&keyword.length!==0){
            // keyword = new String(keyword.getBytes("ISO8859-1"), "UTF-8");
            $.ajax({
                type   :'GET',
                url    :'http://localhost:8080/web_jpetStore_war_exploded//findProduct?keyword='+keyword,
                success:function (data){
                    console.log(keyword);
                    // data=new String(data.getBytes("ISO8859-1"), "UTF-8");
                    console.log(data);
                    var productListHTML='';
                    for(var i=0;i<data.length;i++){
                        productListHTML+='<li class=\"productAutoItem\" data-productId="';
                        productListHTML+=data[i].productId;
                        productListHTML+='">';
                        productListHTML+=data[i].name;
                        productListHTML+='(';
                        productListHTML+=data[i].categoryId;
                        productListHTML+=')';
                        productListHTML+='</li>';
                    }
                    $('#productAutoList').html(productListHTML);
                    $('#productAutoComplete').show();
                },
                error  :function (errorMsg){
                    console.log(errorMsg);
                }
            });
        }else{
            $('#productAutoComplete').hide();
        }

    });

    $(document).on('click','.productAutoItem',function (){
        var productId=$(this).data('productid');
        console.log(productId);
        $('#productAutoComplete').hide();
        $('#keyword').val('');
        window.location.href='http://localhost:8080/web_jpetStore_war_exploded/viewProduct?productId='+productId;
    });
});