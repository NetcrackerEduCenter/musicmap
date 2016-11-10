// VK.init({
//     apiId: 5697583
// });
//
// var button = document.getElementById("getAudio");
// button.addEventListener("mousedown", function (event) {
//     if (event.which == 1) {
//         VK.Auth.login(function (response) {
//             if (response.session) {
//                 /* Пользователь успешно авторизовался */
//                 document.getElementById('userID').value = response.session.mid;
//                 VK.Api.call('audio.get',
//                     {owner_id: response.session.mid},
//                     function (result) {
//                         result.response.shift();
//                         var str = JSON.stringify(result.response, ["aid", "artist", "genre"]);
//                         document.getElementById('audios').value = str;
//                     });
//                 VK.Auth.revokeGrants();
//             }
//             else {
//                 /* Пользователь нажал кнопку Отмена в окне авторизации */
//             }
//         }, 8);
//
//     }
// });