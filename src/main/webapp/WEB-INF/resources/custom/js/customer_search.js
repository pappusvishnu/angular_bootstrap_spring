function initializeCustomerSearch() {
    $(document).ready(function() {

        // === btn listeners ===

        $(document).on("click", ".customer_delete", function() {
            var id = $(this).closest("div .panel").attr("id");

            deleteCustomer(id);
        });

        $(document).on("click", ".customer_edit", function() {
            var id = $(this).closest("div .panel").attr("id");

            isEditButtonVisible(id, false);
        });

        $(document).on("click", ".customer_save", function() {
            var id = $(this).closest("div .panel").attr("id");

            isEditButtonVisible(id, true);
        });

        $(document).on("click", ".customer_cancel", function() {
            var id = $(this).closest("div .panel").attr("id");

            isEditButtonVisible(id, true);
        });
    });

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
}
