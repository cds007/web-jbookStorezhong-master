
$(function (){
    var ids='';
    var $cartQuantity = $('.cartQuantity');
    $cartQuantity.on('blur',function(){
        ids=this.id;
        //this才可以输出出来
        var quantity=this.id+','+this.value;
        $.ajax({
            type     :'GET',
            url      :'http://localhost:8080/web_jpetStore_war_exploded/updateCartJSServlet?quantity='+quantity,
            success  :function (data){
                console.log(data);
                var array=data.split(",");
                var showHTML = '';
                $('#subtotal').text("¥"+array[1]);
                $('#'+ids+'total').text("¥"+array[0]);
            },
            error    :function (errorMsg){
                console.log(errorMsg);
            }
        })
        console.log(ids);
        console.log(quantity);
    });
});