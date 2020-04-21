var url = new URL(window.location.href);
var id = url.searchParams.get("id");
$.get("api/update?id=" + id)
    .done(function (data, textStatus, xhr) {
        if (xhr.status == 200) {
            $("#participantName").val(data.name);
            $("#participantEmail").val(data.email);
            $("#participantLevel").val(data.level);
            $("#participantPrimarySkill").val(data.primarySkill);
            if (data.coverId !== null){
                $("#participant-cover").attr("src", "/BookClub/participant-cover-files/download/" + data.coverId);
            } else {
                $("#participant-cover").attr("src", "https://increasify.com.au/wp-content/uploads/2016/08/default-image.png");
            }
        } else {
            alert("Error!");
        }
    });

$("#save-btn").click(function (event) {
    event.preventDefault();

    var name = $("#participantName").val();
    var email = $("#participantEmail").val();
    var level = $("#participantLevel").val();
    var primarySkill = $("#participantPrimarySkill").val();

    if (name == '' || email == '' || level == '' || primarySkill == '') {
        alert("Please, fill all fields!");
    } else {
        var participant = {
            id,
            name,
            email,
            level,
            primarySkill
        }

        $.post("api/save-update", participant)
            .done(function (data, textStatus, xhr) {
                if (xhr.status == 200) {
                    window.location = window.origin + "/BookClub/"
                } else {
                    alert("Error");
                }
            });
    }

    $.post()
});