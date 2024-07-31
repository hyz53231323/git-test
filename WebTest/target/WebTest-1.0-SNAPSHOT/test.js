function updateTime() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/currentTime", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("currentTime").innerText = xhr.responseText;
        }
    };
    xhr.send();
}
setInterval(updateTime, 1000);