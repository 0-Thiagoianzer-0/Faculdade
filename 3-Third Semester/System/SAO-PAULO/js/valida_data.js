//#####################

//# VALIDAÇÃO DA DATA #

//#####################

function ValidaData(cData){
    var ERRO = false;
    var data = cData; 
    var tam = data.length;
    var separador = "/";
    var dia = data.substr(0,2);
    var mes = data.substr (3,2);
    var ano = data.substr (6,4);
    if(tam > 10){
        ERRO = true;
    }
    /*if(ano < 1980)	{
        return false;
    }
    if(ano > 2010)	{
        return false;
    }
    switch(mes) {
        case '01':
            if(dia <= 31) 
                return(true);
            break;
    }*/
    var newData = data.substr(data, 0, tam - 1);
    if(ERRO == true){
        return newData;
    }else{
        return cData;
    }
}