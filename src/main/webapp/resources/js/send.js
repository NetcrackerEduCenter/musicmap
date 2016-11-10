//
// var button = document.getElementById("send");
// button.addEventListener("mousedown", function (event) {
//     if (event.which == 1) {
//         var coords = document.getElementById('coords').value.split(',');
//         var audios = document.getElementById('audios').value;
//         if (coords == '') {
//             alert("Ошибка. Не определено местоположение.");
//         }
//         else if (coords == 'low accuracy') {
//             alert("Ошибка. Низкая точность местоположения.");
//         }
//         else if (audios == '') {
//             alert("Ошибка. Не получен список аудизаписей.");
//         }
//         else
//             {
//             var result = '{ "userID" : ' + document.getElementById('userID').value
//                 + ', "x" : ' + coords[0] + ', "y" : ' + coords[1]
//                 + ', "audios" : ' + audios + ' }';
//             result = JSON.parse(result);
//             console.log(result);
//         }
//     }
// });