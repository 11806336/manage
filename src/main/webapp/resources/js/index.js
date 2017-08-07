//定位左侧菜单选中状态
$(".btn-meun").on("click", function () {
    $(".btn-meun").removeClass("active");
    $(this).addClass("active");
    $(this).parent().parent().parent().children().removeClass("active");
    $(this).parent().parent().addClass("active");
});
// 滚动条初始化
$('#sidebar').mCustomScrollbar({
    theme: 'minimal-dark',
    scrollInertia: 10,
    axis: 'y',
    mouseWheel: {
        enable: true,
        axis: 'y',
        preventDefault: true
    }
});
/*$(window).resize(function () {
    $('#table').bootstrapTable('resetView');
});*/
//刷新左导航缩放导致表格变形
$("#sidebar-collapse").on("click", function () {
    if($table){
        $table.bootstrapTable(
            "refresh"
        )
    }
});
/**川**
 * Created by RX-005 on 2017/7/24.
 */
