function valida_cpf(cpf) {
    if((cpf = cpf.replace(/[^\d]/g,"")).length != 11)
        return false
    if(cpf == "00000000000" || 
		cpf == "11111111111" || 
		cpf == "22222222222" || 
		cpf == "33333333333" || 
		cpf == "44444444444" || 
		cpf == "55555555555" || 
		cpf == "66666666666" || 
		cpf == "77777777777" || 
		cpf == "88888888888" || 
		cpf == "99999999999")
        return false;
    var r;
    var s = 0;
    for (i=1; i<=9; i++)
        s = s + parseInt(cpf[i-1]) * (11 - i);
        r = (s * 10) % 11;
        if ((r == 10) || (r == 11))
            r = 0;
        if (r != parseInt(cpf[9]))
            return false;
        s = 0;
        for (i = 1; i <= 10; i++)
            s = s + parseInt(cpf[i-1]) * (12 - i);
            r = (s * 10) % 11;
            if ((r == 10) || (r == 11))
                r = 0;
            if (r != parseInt(cpf[10]))
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

function mCPF(cpf){
    cpf=cpf.replace(/\D/g,"")
	cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
	cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
    cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
    return cpf
}

cpfCheck = function(el) {
    document.getElementById('cpfResponse').innerHTML = valida_cpf(el.value)?
    '<span style="color:green">V&aacute;lido</span>' : '<span style="color:red">Inv&aacute;lido</span>';
    if(el.value=='') document.getElementById('cpfResponse').innerHTML = '';
}