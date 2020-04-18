$.get("api/home")
    .done(function (data) {
        var newRow = "";

        jQuery.each(data, function (i, item) {
            newRow += "<tr>" +
                "<td>" + item.id + "</td>" +
                "<td>" + item.name + "</td>" +
                "<td>" + item.email + "</td>" +
                "<td>" + item.level + "</td>" +
                "<td>" + item.primarySkill + "</td>" +
                "<td>" +
                "<button type=\"button\" class=\"btn btn-outline-warning btn-xs edit-participant\" participant-id='" + item.id + "'>" +
                "<i class=\"fas fa-edit\" aria-hidden=\"true\"></i>" +
                "</button>" +
                "</td>" +
                "<td>" +
                "<button type=\"button\" class=\"btn btn-outline-danger btn-xs remove-participant\" participant-id='" + item.id + "'>" +
                "<i class=\"fa fa-trash\" aria-hidden=\"true\"></i>" +
                "</button>" +
                "</td>" +
                "</tr>";
        });

        $("#participants").html(newRow);
        buttonListener();
    })
    .fail(function () {
        alert("Fail");
    });

function buttonListener() {
    $("button.edit-participant").click(function (event) {
        event.preventDefault();

        var participantId = event.target.attributes["participant-id"].value;
        window.location = window.origin + "/BookClub/update?id=" + participantId;
    });

    $("button.remove-participant").click(function (event) {
        event.preventDefault();

        var participantId = event.target.attributes["participant-id"].value;

        $.ajax({
            url: 'api/delete?id=' + participantId,
            type: 'DELETE'
        })
            .done(function () {
                location.reload();
            });
    });
}