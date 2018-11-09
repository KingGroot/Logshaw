var currentPage = 0;
getData();
function searchDatas() {
    var info = document.getElementById("searchinp").value;
    $.ajax({
        type:"post",
        url:"getDataByInfo",
        data:{"currentPage":currentPage,"pageSize":10,"info":info},
        dataType:"JSON",
        success:function (data) {
            var str = null;
            if(data === "没有相关数据!"){
                $("#tbody tr").remove();
                str = "<tr><td colspan='6' style='text-align: center'>没有相关数据!</td></tr>";
                $("#tbody").append(str);
            }else {
                var totalPage = data.totalPages;
                var list = data.list;
                $("#tbody tr").remove();
                for(var i=0;i<list.length;i++){
                    str = "<tr>" +
                        "<td><input type='checkbox' name='ck' id='ckc' value='"+list[i].id+"' onclick='look("+list[i].id+")'/></td>"+
                        "<td class='center'>"+list[i].id+"</td>" +
                        "<td class='center'>"+list[i].num+"</td>" +
                        "<td class='center'>"+list[i].type+"</td>" +
                        "<td class='center'>"+list[i].addTime+"</td>" +
                        "<td class='center'>"+list[i].updataTime+"</td>" +
                        "</tr>";
                    $("#tbody").append(str);
                }
                //分页
                $("#pagination1").pagination({
                    currentPage: currentPage,
                    totalPage: totalPage - 1,
                    callback: function (current) {
                        currentPage = current;
                        searchDatas();
                    }
                });
            }
        }
    });
}

function getData() {
    $.ajax({
        type:"post",
        url:"getAllData",
        data:{"currentPage":currentPage,"pageSize":10},
        dataType:"JSON",
        success:function (data) {
            var str = null;
            if(data === "没有相关数据!"){
                $("#tbody tr").remove();
                str = "<tr><td colspan='6' style='text-align: center'>没有相关数据!</td></tr>";
                $("#tbody").append(str);
            }else {
                var totalPage = data.totalPages;
                var list = data.list;
                $("#tbody tr").remove();
                for(var i=0;i<list.length;i++){
                    str = "<tr>" +
                        "<td><input type='checkbox' name='ck' id='ckc' value='"+list[i].id+"' onclick='look("+list[i].id+")'/></td>"+
                        "<td class='center'>"+list[i].id+"</td>" +
                        "<td class='center'>"+list[i].num+"</td>" +
                        "<td class='center'>"+list[i].type+"</td>" +
                        "<td class='center'>"+list[i].addTime+"</td>" +
                        "<td class='center'>"+list[i].updataTime+"</td>" +
                        "</tr>";
                    $("#tbody").append(str);
                }
                //分页
                $("#pagination1").pagination({
                    currentPage: currentPage,
                    totalPage: totalPage - 1,
                    callback: function (current) {
                        currentPage = current;
                        getData();
                    }
                });
            }
        }
    });
}
//查看对位信息
function look(id) {
    $.ajax({
        type:"post",
        url:"getDataById",
        data:{"id":id},
        dataType:"JSON",
        success:function (data){
            var str1 = data.split("，")[0];
            var str2 = data.split("，")[1];
            var st = "<li style=\"list-style: none;margin-top: 20px;margin-left: 90px\">\n" +
                "<div style=\"width: 200px;height:50px;text-align: center;background-color: #7F7F7F;\">\n" +
                "<p>\n" +
                "<span class=\"aaa\">"+str1.substring(0,1)+"</span>&nbsp;&nbsp;<span class=\"bbb\">"+str1.substring(1,2)+"</span>&nbsp;&nbsp;<span class=\"ccc\">"+str1.substring(2,3)+"</span>&nbsp;&nbsp;\n" +
                "<span class=\"aaa\">"+str1.substring(3,4)+"</span>&nbsp;&nbsp;<span class=\"bbb\">"+str1.substring(4,5)+"</span>&nbsp;&nbsp;<span class=\"ccc\">"+str1.substring(5,6)+"</span>&nbsp;&nbsp;\n" +
                "<span class=\"aaa\">"+str1.substring(6,7)+"</span>&nbsp;&nbsp;<span class=\"bbb\">"+str1.substring(7,8)+"</span>&nbsp;&nbsp;<span class=\"ccc\">"+str1.substring(8,9)+"</span>&nbsp;&nbsp;\n" +
                "</p>\n" +
                "<span class=\"aaa\">"+str2.substring(0,1)+"</span>&nbsp;&nbsp;<span class=\"bbb\">"+str2.substring(1,2)+"</span>&nbsp;&nbsp;<span class=\"ccc\">"+str2.substring(2,3)+"</span>&nbsp;&nbsp;\n" +
                "<span class=\"aaa\">"+str2.substring(3,4)+"</span>&nbsp;&nbsp;<span class=\"bbb\">"+str2.substring(4,5)+"</span>&nbsp;&nbsp;<span class=\"ccc\">"+str2.substring(5,6)+"</span>&nbsp;&nbsp;\n" +
                "<span class=\"aaa\">"+str2.substring(6,7)+"</span>&nbsp;&nbsp;<span class=\"bbb\">"+str2.substring(7,8)+"</span>&nbsp;&nbsp;<span class=\"ccc\">"+str2.substring(8,9)+"</span>&nbsp;&nbsp;\n" +
                "</div>\n" +
                "</li>";

            $('#CounterpositionUl').append(st);

        }
    });
}

//清空对位信息
function clearDatas() {
    $('#CounterpositionUl li').remove();
}