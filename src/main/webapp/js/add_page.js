$("#add-btn").click(function () {
    var name = $("#participantName").val();
    var email = $("#participantEmail").val();
    var level = $("#participantLevel").val();
    var primarySkill = $("#participantPrimarySkill").val();
    var coverId = $("#cover-id").val();

    if (name == '' || email == '' || level == '' || primarySkill == '') {
        alert("Please, fill all fields!");
    } else {
        var participant = {
            name,
            email,
            level,
            primarySkill,
            coverId
        }

        $.post("api/add", participant)
            .done(function (data, textStatus, xhr) {
                if (xhr.status == 200) {
                    window.location = window.origin + "/BookClub/"
                } else {
                    alert("Error");
                }
            });
    }
});
