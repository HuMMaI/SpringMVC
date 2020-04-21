<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <form action="/BookClub/api/update" method="POST">
        <div class="form-group">
            <label for="participantName">Name:</label>
            <input type="text" class="form-control" id="participantName" placeholder="Enter name">
        </div>
        <div class="form-group">
            <label for="participantEmail">Email:</label>
            <input type="email" class="form-control" id="participantEmail" placeholder="Enter email">
        </div>
        <div class="form-group">
            <label for="participantName">Level:</label>
            <select class="form-control" id="participantLevel">
                <option>L1</option>
                <option>L2</option>
                <option>L3</option>
                <option>L4</option>
                <option>L5</option>
            </select>
        </div>
        <div class="form-group">
            <label for="participantPrimarySkill">Primary skill:</label>
            <input type="text" class="form-control" id="participantPrimarySkill" placeholder="Enter primary skill">
        </div>
        <div class="form-group">
            <img src="" id="participant-cover" width="200px" style="margin-bottom: .5rem;">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Upload</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="cover-file" name="file">
                    <label class="custom-file-label" for="cover-file">Choose file</label>
                </div>
            </div>
            <input type="hidden" value="" class="form-control" id="cover-id" name="coverId">
        </div>
        <button type="submit" class="btn btn-primary" id="save-btn">Save</button>
    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/js/participant_edit_page.js"></script>
<script src="${pageContext.request.contextPath}/js/participant_cover_file.js"></script>
</body>
</html>
