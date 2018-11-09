getAll();

function getAll() {
    $("#tbody tr").remove();
    $.ajax({
        type:"post",
        url:"/data-analysis/getAllQd",
        dataType:"JSON",
        success:function (data) {
            for(var i=0;i<data.length;i++){
                var str = null;
                if(data[i].zk === "主场"){
                    str = "<tr>" +
                        "<td><input type='checkbox' name='check' value='"+data[i].id+"'></td>" +
                        "<td>"+data[i].qd+"</td>" +
                        "<td>"+data[i].sj+"</td>" +
                        "<td>"+data[i].zk+"</td>" +
                        "<td><span style='color: red'>"+data[i].pm1+"</span> vs "+data[i].pm2+"</td>" +
                        "<td><span style='color: red'>"+data[i].bf1+"</span> : "+data[i].bf2+"</td>" +
                        "<td>"+data[i].kql+"%"+"——"+data[i].jgcs+"——"+data[i].wxjg+"——"+data[i].smcs+"——"+data[i].szcs+"——"+data[i].jqs+"</td>" +
                        "<td>"+(data[i].jgcs/(data[i].kql/100)).toFixed(2)+"——"+(data[i].wxjg/data[i].jgcs).toFixed(2)+"——"+(data[i].smcs/data[i].wxjg).toFixed(2)+"——"+(data[i].szcs/data[i].smcs).toFixed(2)+"——"+(data[i].jqs/data[i].szcs).toFixed(2)+"</td>" +
                        "</tr>";
                }else {
                    str = "<tr>" +
                        "<td><input type='checkbox' name='check' value='"+data[i].id+"'></td>" +
                        "<td>"+data[i].qd+"</td>" +
                        "<td>"+data[i].sj+"</td>" +
                        "<td>"+data[i].zk+"</td>" +
                        "<td>"+data[i].pm1+" vs <span style='color: red'>"+data[i].pm2+"</span></td>" +
                        "<td>"+data[i].bf1+" : <span style='color: red'>"+data[i].bf2+"</span></td>" +
                        "<td>"+data[i].kql+"%"+"——"+data[i].jgcs+"——"+data[i].wxjg+"——"+data[i].smcs+"——"+data[i].szcs+"——"+data[i].jqs+"</td>" +
                        "<td>"+(data[i].jgcs/(data[i].kql/100)).toFixed(2)+"——"+(data[i].wxjg/data[i].jgcs).toFixed(2)+"——"+(data[i].smcs/data[i].wxjg).toFixed(2)+"——"+(data[i].szcs/data[i].smcs).toFixed(2)+"——"+(data[i].jqs/data[i].szcs).toFixed(2)+"</td>" +
                        "</tr>";
                }
                $("#tbody").append(str);
            }
        }
    });
}

function findQdinfo() {
    $("#tbody tr").remove();
    $.ajax({
        type: "post",
        url: "getQdDataByQd",
        data:{"sq":$("#sq").val(),"qd":$("#qd").val()},
        dataType: "JSON",
        success: function (data) {
            if(data.length === 0){
                alert("没有相关数据！");
                return false;
            }else {
                for(var i=0;i<data.length;i++){
                    var str = null;
                    if(data[i].zk === "主场"){
                        str = "<tr>" +
                            "<td><input type='checkbox' name='check' value='"+data[i].id+"'></td>" +
                            "<td>"+data[i].qd+"</td>" +
                            "<td>"+data[i].sj+"</td>" +
                            "<td>"+data[i].zk+"</td>" +
                            "<td><span style='color: red'>"+data[i].pm1+"</span> vs "+data[i].pm2+"</td>" +
                            "<td><span style='color: red'>"+data[i].bf1+"</span> : "+data[i].bf2+"</td>" +
                            "<td>"+data[i].kql+"%"+"——"+data[i].jgcs+"——"+data[i].wxjg+"——"+data[i].smcs+"——"+data[i].szcs+"——"+data[i].jqs+"</td>" +
                            "<td>"+(data[i].jgcs/(data[i].kql/100)).toFixed(2)+"——"+(data[i].wxjg/data[i].jgcs).toFixed(2)+"——"+(data[i].smcs/data[i].wxjg).toFixed(2)+"——"+(data[i].szcs/data[i].smcs).toFixed(2)+"——"+(data[i].jqs/data[i].szcs).toFixed(2)+"</td>" +
                            "</tr>";
                    }else {
                        str = "<tr>" +
                            "<td><input type='checkbox' name='check' value='"+data[i].id+"'></td>" +
                            "<td>"+data[i].qd+"</td>" +
                            "<td>"+data[i].sj+"</td>" +
                            "<td>"+data[i].zk+"</td>" +
                            "<td>"+data[i].pm1+" vs <span style='color: red'>"+data[i].pm2+"</span></td>" +
                            "<td>"+data[i].bf1+" : <span style='color: red'>"+data[i].bf2+"</span></td>" +
                            "<td>"+data[i].kql+"%"+"——"+data[i].jgcs+"——"+data[i].wxjg+"——"+data[i].smcs+"——"+data[i].szcs+"——"+data[i].jqs+"</td>" +
                            "<td>"+(data[i].jgcs/(data[i].kql/100)).toFixed(2)+"——"+(data[i].wxjg/data[i].jgcs).toFixed(2)+"——"+(data[i].smcs/data[i].wxjg).toFixed(2)+"——"+(data[i].szcs/data[i].smcs).toFixed(2)+"——"+(data[i].jqs/data[i].szcs).toFixed(2)+"</td>" +
                            "</tr>";
                    }
                    $("#tbody").append(str);
                }
            }
        }
    });
}

$("#getValue").click(function(){
    var obj=document.getElementsByName('check'); //选择所有name="'test'"的对象，返回数组
    //取到对象数组后，我们来循环检测它是不是被选中
    var s='';
    for(var i=0; i<obj.length; i++){
        if(obj[i].checked) s+=obj[i].value+','; //如果选中，将value添加到变量s中
    }
    //那么现在来检测s的值就知道选中的复选框的值了
    alert(s===''?'你还没有选择任何内容！':s);
});