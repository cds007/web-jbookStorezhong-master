function overFn1(obj){//鼠标在上面
    let area = obj;
    console.log(area.className);
    sendRequest(area.className);

}

function outFn1(){//鼠标离开
    let content = "";
    var informDiv = document.getElementById('inform');
    var x=event.clientX;
    var y=event.clientY;
    var divx1 = informDiv.offsetLeft;
    var divy1 = informDiv.offsetTop;
    var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
    var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
    if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
        document.getElementById('inform').style.display='none';
    }


}

var xhr = '';

function showInform(categoryId) {
    console.log("111");
    console.log(categoryId);
    sendRequest(categoryId);
}
function sendRequest(id) {
    console.log("222");
    xhr = new XMLHttpRequest();
    xhr.onreadystatechange = process;
    xhr.open('GET', 'ItemDetailServlet?productId='+id);
    xhr.send(null);

}

function process(){
    if(xhr.readyState === 4){
        if(xhr.status === 200){
            var responseInfo = xhr.responseText;


            //显示悬浮层
            var inform = document.getElementById("inform");
            inform.innerText = responseInfo;
            inform.style.display = "block";

        }
    }
}

window.onload = function () {

    var pos =  $('#inform').offset();// offset() 获得div1当前的位置，左上角坐标(x,y)
    $(window).scroll(function () { //滚动条滚动事件
        if ($(this).scrollTop() > pos.top ) {
            $('#inform').css('width', '100px').css('top', $(this).scrollTop() - pos.top);
        } else if ($(this).scrollTop() <=  pos.top ) {
            $('#inform').css('width', '100x').css('top',0).css('position', 'relative');
        }

    })

};
