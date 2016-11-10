<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://vk.com/js/api/openapi.js?136" type="text/javascript"></script>
    <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>



    <link href="resources/css/main.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>

<div id="main">
    <div id="header">
        <input type="hidden" id="coords">
        <input type="hidden" id="audios">
        <input type="hidden" id="userID">
        <div class="btn-group" role="group" aria-label="...">
            <button type="button" class="btn btn-default" id="findMe">Find me</button>
            <button type="button" class="btn btn-default" id="getAudio">Get audio</button>
            <button type="button" class="btn btn-default" id="send">Send</button>
        </div>

    </div>

    <div id="map"></div>
</div>
</body>

<script src="resources/js/start.js" type="text/javascript"></script>
<%--<script src="resources/js/getAudio.js" type="text/javascript"></script>--%>
<%--<script src="resources/js/send.js" type="text/javascript"></script>--%>
</html>
