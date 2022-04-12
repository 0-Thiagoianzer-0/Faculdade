function lista_estado() {
    http.open("GET", "consulta/estado/monta_select_estado.php?", true);
    http.onreadystatechange = handleHttpResponse;
    http.send(null);
}

function handleHttpResponse() {
    campo_select = document.forms[0].cmbEstado;
    if (http.readyState == 4) {
        campo_select.options.length = 0;
        results = http.responseText.split(",");
        for (i = 0; i < results.length; i++) {
            string = results[i].split("|");
            campo_select.options[i] = new Option(string[0], string[1]);
        }
        campo_select.value = "0";
    }
}

function getHTTPObject(){
    var req;
    try {
        if (window.XMLHttpRequest) {
            req = new XMLHttpRequest();
            if (req.readyState == null) {
                req.readyState = 1;
                req.addEventListener("load",
                    function () {
                        req.readyState = 4;
                        if (typeof req.onReadyStateChange == "function")
                            req.onReadyStateChange();
                    }, false);
            }
            return req;
        }
        if (window.ActiveXObject) {
            var prefixes = ["MSXML2", "Microsoft", "MSXML", "MSXML3"];
            for (var i = 0; i < prefixes.length; i++) {
                try {
                    req = new ActiveXObject(prefixes[i] + ".XmlHttp");
                    return req;
                }
                catch (ex) { };
            }
        }
    } catch (ex) { }
    alert("XmlHttp Objects not supported by client browser");
}

var http = getHTTPObject();