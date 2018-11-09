var currentPage = 0;
getData();
function tijiao() {
    var info = document.getElementById("inp").value;
    document.getElementById("inp").value = "";
    if(info.length !== 19){
        alert("数据格式不正确，请重新输入！");
    }else {
        $.ajax({
            type:"post",
            url:"addData",
            data:{"info":info},
            dataType:"JSON",
            success:function (data) {
                if(data === "false"){
                    alert("数据添加失败！")
                }else {
                    getData();
                }
            }
        });
    }
}

function getData() {
    $.ajax({
        type:"post",
        url:"getAllData",
        data:{"currentPage":currentPage,"pageSize":5},
        dataType:"JSON",
        success:function (data) {
            var totalPage = data.totalPages;
            var list = data.list;
            $("#tbody tr").remove();
            for(var i=0;i<list.length;i++){
                var str = "<tr>" +
                    "<td class='center'>"+list[i].id+"</td>" +
                    "<td class='center'>"+changeColor(list[i].num)+"</td>" +
                    "<td class='center'>"+list[i].type+"</td>" +
                    "<td class='center'>"+list[i].addTime+"</td>" +
                    "<td class='center'>"+list[i].updataTime+"</td>" +
                    "<td>" +
                    "<button class='btn btn-danger btn-sm' onclick='deleteById("+list[i].id+")'>删除</button>" +
                    "<button class='btn btn-primary btn-sm' onclick='updataById("+list[i].id+")'>修改</button>" +
                    "</td>"+
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
    });
}

function deleteById(id) {
    $.ajax({
        type:"post",
        url:"deleteDataById",
        data:{"id":id},
        dataType:"JSON",
        success:function (data) {
            if(data === "success"){
                getData();
            }
        }
    });
}

function updataById() {
    alert("此功能待完善");
}

//改变字符串最后一个字符的颜色
function changeColor(str) {
    //获取最后一位字符
    var newStr = str[str.length-1];
    //改变最后一位字符的颜色
    return str.substring(0,str.length-1)+"<span style='color: red'>"+newStr+"</span>";
}