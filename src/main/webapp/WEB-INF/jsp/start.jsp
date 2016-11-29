<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MusicMap</title>

    <link href="resources/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/materialize.css">
    <%--<link href="resources/css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<div id="main">
    <div>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <div class="drawer-title">Выбранный район</div>
            <div class="drawer-content" id="regionName"></div>
            <div class="drawer-title">Количество пользователей</div>
            <div class="drawer-content" id="numberOfUsers"></div>
            <div class="drawer-title">Рейтинг</div>
            <div class="drawer-content" id="rating">Рейтинг</div>
        </div>
        <div id="top_buttons">
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default waves-effect waves-light" id="findMe">Find me</button>
                <button type="button" class="btn btn-default waves-effect waves-light" id="getAudio">Get audio</button>
                <button type="button" class="btn btn-default waves-effect waves-light" id="send">Send</button>
            </div>
        </div>
        <div id="map"></div>
    </div>
</div>
</body>

<script src="https://vk.com/js/api/openapi.js?136" type="text/javascript"></script>
<script src="//api-maps.yandex.ru/2.1/?lang=ru_RU&coordorder=longlat" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/locations.js" type="text/javascript"></script>
<script src="resources/js/start.js" type="text/javascript"></script>
<script src="resources/js/dropdown.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>

</html>
