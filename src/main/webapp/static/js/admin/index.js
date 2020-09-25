//JavaScript代码区域


$.ajax({
    url: '/adminmenu',
    type: 'post',
    dataType: 'json',
    success: function (data) {
        var datas = data.data;
        //展示主菜单

        var str = '';

        for (var json of datas) {

            str = str + '<li class="layui-nav-item layui-nav-itemed">\n' +
                '    <a href="javascript:;"  lay-direction="2">\n' +
                '        <i class="layui-icon ' + json.imageShow + '"></i>\n' +
                '        <cite class="font-color">' + json.menuName + '</cite>\n' +
                '    </a>';


            //迭代子菜单

            var sonstr = sonMenu(json.sonMenus, '');
            str = str + sonstr + '</li>';

        }


        $('#LAY-system-side-menu').html(str);
    }
})

function sonMenu(sonmenus) {
    if (sonmenus.length == 0) {
        return;
    } else {
        var str = '<dl class="layui-nav-child layui-nav-itemed">';
        for (var json of sonmenus) {
            if (json.sonMenus.length == 0) {
                str = str + '<dd><a href="' + (json.url == '' ? "javascript:;" : json.url) + '"' + (json.url == '' ? "" : 'target="frame"') + ' >' + json.menuName + '</a>';
            }
            var sonstr = '';
            if (json.sonMenus.length != 0) {
                sonstr = sonMenu(json.sonMenus);

            }
            str = str + sonstr + ' </dd>';
        }

        str = str + '</dl>';
        return str;
    }


}
