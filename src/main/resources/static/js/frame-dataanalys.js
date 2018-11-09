function saveData() {
    $.ajax({
        type:"post",
        url:"savaQsData",
        data:{
            "qd":$("#qd").val(),
            "sj":$("#sj").val(),
            "zk":$("#zk").val(),
            "pm1":$("#sqpm1").val(),
            "pm2":$("#sqpm2").val(),
            "bf1":$("#fs1").val(),
            "bf2":$("#fs2").val(),
            "kql":$("#kql").val(),
            "jgcs":$("#jgcs").val(),
            "wxjg":$("#wxjg").val(),
            "smcs":$("#smcs").val(),
            "szcs":$("#szcs").val(),
            "jqs":$("#jqs").val(),
            "sq":$("#sq").val()
        },
        dataType:"JSON",
        success:function (data) {
            location = location
        }
    });
}