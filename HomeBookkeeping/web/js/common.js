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
                if (data === 'Category name is already exists.') {
                    M.toast({html: data});
                    return;
                } else if (data !== null) {
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
                categoryType: categoryType,
                active: "true"
            },
            success: function (data) {
                $(".changing-category").html(data);
            }
        });
    });
    
    $(".category-deactivate-type").change(function() {
        var categoryType = $(".category-deactivate-type").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CATEGORY_LIST_BY_TYPE",
                categoryType: categoryType,
                active: "false"
            },
            success: function (data) {
                $(".inactive-categories").html(data);
            }
        });
    });
    
    $(".send-rename").click(function() {
        var curTitle = $(".changing-category").val();
        var newTitle = $(".category-rename-input input").val();
        var type = $(".category-change-type").val();
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CATEGORY_RENAME",
                curTitle: curTitle,
                newTitle: newTitle,
                type: type
            },
            success: function (data) {
                $(".changing-category option:contains(" + curTitle + ")").text(newTitle);
                M.toast({html: 'Category was renamed.'});
            }
        });
    });
    
    $(".send-deactivate").click(function() {
        var changedCategoryType = $(".category-change-type").val();
        var secondCategoryType = $(".category-deactivate-type").val();
        var categoryName = $(".changing-category").val();
        var changedCategoryActive = "true";
        
        if ( isEmpty(categoryName) ) {
            return false;
        }
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CATEGORY_CHANGE_ACTIVATE",
                changedCategoryType: changedCategoryType,
                secondCategoryType: secondCategoryType,
                categoryName: categoryName,
                changedCategoryActive: changedCategoryActive
            },
            success: function (data) {
                data = JSON.parse(data);
                $(".changing-category").html(data.changedCategories);
                
                if (data.inactiveCategories !== null) {
                    $(".inactive-categories").html(data.secondCategories);
                }
                
                M.toast({html: 'Category was deactivated.'});
            }
        });
    });
    
    $(".send-activate").click(function() {
        var changedCategoryType = $(".category-deactivate-type").val();
        var secondCategoryType = $(".category-change-type").val();
        var categoryName = $(".inactive-categories").val();
        var changedCategoryActive = "false";
        
        if ( isEmpty(categoryName) ) {
            return false;
        }
        
        $.ajax({
            url: "ajaxController",
            data: {
                action: "CATEGORY_CHANGE_ACTIVATE",
                categoryName: categoryName,
                secondCategoryType: secondCategoryType,
                changedCategoryType: changedCategoryType,
                changedCategoryActive: changedCategoryActive
            },
            success: function (data) {
                data = JSON.parse(data);
                $(".inactive-categories").html(data.changedCategories);
                
                if (data.activeCategories !== null) {
                    $(".changing-category").html(data.secondCategories);
                }
                
                M.toast({html: 'Category was activated.'});
            }
        });
    });
});

function isEmpty(str) {
    return !str || !str.length;
}

/*function sendDelete(categoryNameClass, categoryTypeClass) {
    var categoryName = $(categoryNameClass).val();
    var categoryType = $(categoryTypeClass).val();
    
    if ( isEmpty(categoryName) ) {
        return false;
    }
    
    var sure = alert("Are you sure ?");
    
    if (sure) {
        $.ajax({
            url: "ajaxController",
            data: {
                action: "DELETE_CATEGORY",
                categoryName: categoryName,
                categoryType: categoryType,
            }
        });
    }
}*/