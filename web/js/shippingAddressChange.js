$(function (){
    var $require = $('#shippingAddressRequired');

    var  obj = document.getElementsByName("shippingAddressRequired");
    var judge = document.getElementsByClassName("shippingComplete");
    var $context = $('.shippingCompleteContext');
    var names='';
    var values='';
    $('#shippingAddressRequired').on('click',function (){
        if (obj[0].checked){
            $('#shippingComplete1').show();
            console.log("yes");
        }else{
            for(var i=0;i<judge.length;i++){
                judge[i].style.display = "";
            }
            console.log("no");
        }
    });
    $context.on('blur',function (){
        names=this.name;
        values=this.value;
        console.log(names);
        console.log("show");
        $.ajax({
            type     :'GET',
            url      :'http://localhost:8080/web_jpetStore_war_exploded/shippingAddressChange?context='+names+','+values,
            success  :function (data){
                console.log(data);
                // var array=data.split(",");
                // var showHTML = '';
                // $('#subtotal').text(array[1]);
                // $('#'+ids+'total').text(array[0]);
            },
            error    :function (errorMsg){
                console.log(errorMsg);
            }
        });
    });

    //记录第二个出现的问题，一开始用的是%('#shippingComplete1').style.display='none'，不可以，改成了网上说的方法。
    //记录第一个出现的问题，checkbox无法判断是否chencked，会出现undefined，改成了obj[0]就可以了。











    var baseTable=[];
    for(var i in obj){
        if(obj[i].checked){
            baseTable.push(obj[i].value);
            console.log(obj[i].value);
        }
    }

    if ($require.checked){
        console.log($require.checked);
        console.log($require.value);
        console.log($('#shippingAddressRequired').value);
        console.log($('#shippingAddressRequired').name);
        console.log("yes");
    }else{
        console.log($require.checked);
        console.log($require.value);
        console.log($('#shippingAddressRequired').value);
        console.log($('#shippingAddressRequired').name);
        console.log("no");
    }

});