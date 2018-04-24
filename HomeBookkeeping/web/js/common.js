$(document).ready(function() {
    $(".sidenav").sidenav();
    
    //ajax income-adding-select
    $(".income-send").click(function() {
        var category = $(".income-adding-select").val();
        var sum = $(".income-sum").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                category: category,
                sum: sum
            },
            type: "get",
            success: function (data) {
                
            }
        });
    });
});