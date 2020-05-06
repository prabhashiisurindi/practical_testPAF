$(document).ready(function () {

    $.ajax(
        {
            url: "PaymentsAPI",
            type: "GET",
            data: "",
            dataType: "text",
            complete: function (response, status) {
                onLoadData(response.responseText, status);
            }
        });
    $("#alertSuccess").hide();
    $("#alertError").hide();

});

function onLoadData(response, status) {
    if (status == "success") {
        $("#paymentsGrid").html(response);
    }
}

// SAVE ============================================
$(document).on("click", "#btnSave", function (event) {


    // Clear status msges-------------
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();

    // Form validation----------------
    var status = validatePaymentForm();


    // If not valid-------------------
    if (status == true) {

        addNewPayment();
    } else {
        $("#alertError").text(status);
        $("#alertError").show();
        return;
    }


    $("#alertSuccess").text("Saved successfully.");
    $("#alertSuccess").show();

    $("#formPayment")[0].reset();
});


function validatePaymentForm() {
    // NAME
    if ($("#patientName").val().trim() == "") {

        return "Insert patient name.";

    }
    // Amount
    if ($("#amout").val().trim() == "") {

        return "Insert amount .";

    }
    // Type
    if ($("#type").val() == "0") {

        return "Select payment type.";

    }
    //Date
    if ($("#date").val() == "") {

        return "Select payment type.";

    }

    return true;
}

function addNewPayment() {
    var type = ($("#paymentId").val() == "") ? "POST" : "PUT";
    $.ajax(
        {
            url: "PaymentsAPI",
            type: type,
            data: $("#formPayment").serialize(),
            dataType: "text",
            complete: function (response, status) {
                onPyamentSave(response.responseText, status);
            }
        });
    clearForm();
}

function deletePayment(paymentId) {
    alert(paymentId);

}

function onPyamentSave(response, status) {
    if (status == "success") {
        $("#paymentsGrid").html(response);
        $("#alertSuccess").text("Successfully added.");
        $("#alertSuccess").show();
    } else {
        $("#alertError").text("Cannot Save.");
        $("#alertError").show();
    }

}

$(document).on("click", ".btnUpdate", function (event) {
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();
    $("#paymentId").val($(this).closest("tr").find('#paymentHiddenId').val());
    $("#patientName").val($(this).closest("tr").find('td:eq(0)').text());
    $("#amout").val($(this).closest("tr").find('td:eq(1)').text());
    $("#type").val($(this).closest("tr").find('td:eq(2)').text());
    $("#date").val($(this).closest("tr").find('td:eq(3)').text());
});

$(document).on("click", ".btnRemove", function (event) {
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();
    $.ajax(
        {
            url: "PaymentsAPI",
            type: "DELETE",
            data: "paymentId=" + $(this).closest("tr").find('#paymentHiddenId').val(),
            dataType: "text",
            complete: function (response, status) {
                console.log(response, status);
                onPaymentDelete(response.responseText, status);
            }
        });
    clearForm();
});


function onPaymentDelete(response, status) {
    if (status == "success") {
        $("#paymentsGrid").html(response);
        $("#alertSuccess").text("Successfully Deleted.");
        $("#alertSuccess").show();
    } else {
        $("#alertError").text("Cannot Delete.");
        $("#alertError").show();
    }

}


function clearForm() {
    $("#paymentId").val("");
    $("#patientName").val("");
    $("#amout").val("");
    $("#type").val("");
    $("#date").val("");
}

