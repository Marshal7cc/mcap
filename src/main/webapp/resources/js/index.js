$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "sys/function/getMenus",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: "text",
        success: function (responseData) {
            var functionNodes = JSON.parse(responseData);
            //console.log(functionNodes);
            var menuHtml = '';
            menuHtml += parseTopFunctions(functionNodes);
            $('.sidebar-menu').append(menuHtml);
        },
        error: function (e) {
            console.log(e);
        }
    });

    function parseTopFunctions(functionList) {
        var menuHtml = "";
        functionList.forEach(function (item) {
            if (item.childFunctions == undefined || item.childFunctions == null) {
                menuHtml += '<li>\n' +
                    '    <a href="javascript:$(\'#mainframe\').attr(\'src\',\''+item.url+'\')"><i class="' + item.functionIcon + '"></i> <span>' + item.functionName + '</span></a>\n' +
                    '</li>';
            } else if(item.childFunctions!=undefined){
                menuHtml += '<li class="treeview">\n' +
                    '            <a href="#"><i class="'+item.functionIcon+'"></i> <span>'+item.functionName+'</span>\n' +
                    '                <span class="pull-right-container">\n' +
                    '                            <i class="fa fa-angle-left pull-right"></i>\n' +
                    '                        </span>\n' +
                    '            </a>\n' +
                    '            <ul class="treeview-menu">';
                menuHtml += parseTopFunctions(item.childFunctions);
                menuHtml += '</ul>\n' +
                    '        </li>';
            }
        });
        return menuHtml;
    }

    function turnToFunction(url){
        $('#mainframe').attr('src',url);
    }

});