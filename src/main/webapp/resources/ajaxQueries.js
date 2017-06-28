
$(".itemState").click(function () {
    var itemId = $(this).attr("data-itemId");
    var button = $(this);
    $.ajax({
        type: "POST",
        data: {
            id: itemId
        },
        url: "/changeState",
        success: function (result) {

            if (result == "yes"){
                button.text("✔");
            } else if(result == "no"){
                button.text("❌");
            }

        }
    });
});

$(".removeUser").click(function () {
    var userId = $(this).attr("data-userId");
    $.ajax({
        type: "POST",
        data: {
            id: userId
        },
        url: "/removeUser",
        success: function (result) {

        }
    });
});