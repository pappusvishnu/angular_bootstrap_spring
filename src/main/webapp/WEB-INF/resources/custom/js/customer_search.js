function initializeEditableField(id) {
    toggleEditable(id, true);
}

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

    toggleEditable(id, show);
}

function toggleEditable(id, show) {
    $("#" + id + " #customer_first").editable('option', 'disabled', show);
    $("#" + id + " #customer_last").editable('option', 'disabled', show);
};
