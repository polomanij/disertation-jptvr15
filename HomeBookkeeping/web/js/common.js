$(document).ready(function() {
    //mobile sidenav materializecss
    $(".sidenav").sidenav();
    
    //ajax handlers
    //ajax income adding
    $(".income-send").click(function() {
        var category = $(".income-adding-select").val();
        var sum = $(".income-sum").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "ADD_REPORT",
                category: category,
                sum: sum,
                type: "income"
            },
            type: "get",
            success: function (data) {
                data = JSON.parse(data);
                
                var creditText = data.credit + " EUR";
                var lastIncomeText = data.lastReportText;

                $(".workspace-credit").text(creditText);
                $(".workspace-last-income").text(lastIncomeText);
            }
        });
    });
    
    //ajax expense adding
    $(".expense-send").click(function() {
        var category = $(".expense-adding-select").val();
        var sum = $(".expense-sum").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "ADD_REPORT",
                category: category,
                sum: sum,
                type: "expense"
            },
            type: "get",
            success: function (data) {
                data = JSON.parse(data);

                var creditText = data.credit + " EUR";
                var lastExpenseText = data.lastReportText;

                $(".workspace-credit").text(creditText);
                $(".workspace-last-expense").text(lastExpenseText);
            }
        });
    });
    
    //ajax create category
    $(".create-category").click(function() {
        var newCategoryTitle = $(".new-category-title").val();
        var newCategoryType = $(".new-category-type").val();
        var categoryChangeType = $(".category-change-type").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CREATE_CATEGORY",
                newCategoryTitle: newCategoryTitle,
                newCategoryType: newCategoryType,
                categoryChangeType: categoryChangeType
            },
            type: "get",
            success: function (data) {
                data = JSON.parse(data);
                if (data !== null) {
                    $(".changing-category").html(data);
                }
                
                M.toast({html: 'Category was created.'});
            }
        });
    });
    
    $(".category-change-type").change(function() {
        var categoryType = $(".category-change-type").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CATEGORY_LIST_BY_TYPE",
                categoryType: categoryType
            },
            success: function (data) {
                $(".changing-category").html(data);
            }
        });
    });
    
    $(".send-rename").click(function() {
        var curTitle = $(".changing-category").val();
        var newTitle = $(".category-rename-input input").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CATEGORY_RENAME",
                curTitle: curTitle,
                newTitle: newTitle
            },
            success: function (data) {
                $(".changing-category option:contains(" + curTitle + ")").text(newTitle);
                M.toast({html: 'Category was renamed.'});
            }
        });
    });
});