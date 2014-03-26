function isEditButtonVisible(id, show) {
    if(show) {
        $("#" + id + " .customer_edit").show();
        $("#" + id + " .customer_save").hide();
        $("#" + id + " .customer_cancel").hide();
    }
    else {
        $("#" + id + " .customer_edit").hide();
        $("#" + id + " .customer_save").show();
        $("#" + id + " .customer_cancel").show();
    }
}
