$(document).ready(function() {
    $(".sidenav").sidenav();
    
    //ajax income adding
    $(".income-send").click(function() {
        var category = $(".income-adding-select").val();
        var sum = $(".income-sum").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                category: category,
                sum: sum,
                type: "income"
            },
            type: "get",
            success: function (data) {
                alert(data);
            }
        });
    });
});