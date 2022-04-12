function valida_telefone(telefone) {
    if((telefone = telefone.replace(/[^\d]/g,"")).length < 10)
        return false
    if(telefone == "00000000000" ||
        telefone == "11111111111" ||
        telefone == "22222222222" ||
        telefone == "33333333333" ||
        telefone == "44444444444" ||
        telefone == "55555555555" ||
        telefone == "66666666666" ||
        telefone == "77777777777" ||
        telefone == "88888888888" ||
        telefone == "99999999999" ||
        telefone == "0000000000" ||
        telefone == "1111111111" ||
        telefone == "2222222222" ||
        telefone == "3333333333" ||
        telefone == "4444444444" ||
        telefone == "5555555555" ||
        telefone == "6666666666" ||
        telefone == "7777777777" ||
        telefone == "8888888888" ||
        telefone == "9999999999")
        return false;
    return true;
}

function fMasc(objeto,mascara) {
    obj=objeto
    masc=mascara
    setTimeout("fMascEx()",1)
}

function fMascEx() {
    obj.value=masc(obj.value)
}

function mTEL(telefone){
    if((telefone = telefone.replace(/[^\d]/g,"")).length <= 10){
        telefone=telefone.replace(/\D/g,"")
        telefone=telefone.replace(/(\d{2})(\d)/,"($1)$2")
        telefone=telefone.replace(/(\d{4})(\d{1,4})$/," $1-$2")
        return telefone
    }else{
        telefone=telefone.replace(/\D/g,"")
        telefone=telefone.replace(/(\d{2})(\d)/,"($1)$2")
        telefone=telefone.replace(/(\d{5})(\d{1,4})$/," $1-$2")
        return telefone
    }
}

telCheck = function(el) {
    document.getElementById('telefoneResponse').innerHTML = valida_telefone(el.value)?
    '<span style="color:green">V&aacute;lido</span>' : '<span style="color:red">Inv&aacute;lido</span>';
    if(el.value=='') document.getElementById('telefoneResponse').innerHTML = '';
}

adicionalCheck = function(el) {
    document.getElementById('adicionalResponse').innerHTML = valida_telefone(el.value)?
    '<span style="color:green">V&aacute;lido</span>' : '<span style="color:red">Inv&aacute;lido</span>';
    if(el.value=='') document.getElementById('adicionalResponse').innerHTML = '';
}