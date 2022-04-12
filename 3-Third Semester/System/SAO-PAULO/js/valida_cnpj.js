function valida_cnpj(cnpj) {
	cnpj = cnpj.replace(/[^\d]+/g,'');
	if(cnpj == '')
		return false;
	if(cnpj.length != 14)
        return false;
	//CNPJ inválidos
    if(cnpj == "00000000000000" || 
		cnpj == "11111111111111" || 
		cnpj == "22222222222222" || 
		cnpj == "33333333333333" || 
		cnpj == "44444444444444" || 
		cnpj == "55555555555555" || 
		cnpj == "66666666666666" || 
		cnpj == "77777777777777" || 
		cnpj == "88888888888888" || 
		cnpj == "99999999999999")
		return false;
	//Válida os dados
	tamanho = cnpj.length - 2
	numeros = cnpj.substring(0,tamanho);
	digitos = cnpj.substring(tamanho);
	soma = 0;
	pos = tamanho - 7;
	for(i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if(pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if(resultado != digitos.charAt(0))
		return false;
	tamanho = tamanho + 1;
	numeros = cnpj.substring(0,tamanho);
	soma = 0;
	pos = tamanho - 7;
	for(i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if(resultado != digitos.charAt(1))
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

function mCNPJ(cnpj){
	cnpj = cnpj.replace(/^(\d{2})(\d)/, "$1.$2")
	cnpj = cnpj.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3")
	cnpj = cnpj.replace(/\.(\d{3})(\d)/, ".$1/$2")
	cnpj = cnpj.replace(/(\d{4})(\d)/, "$1-$2") 
	return cnpj
}

cnpjCheck = function (el) {
    document.getElementById('cnpjResponse').innerHTML = valida_cnpj(el.value)?
    '<span style="color:green">V&aacute;lido</span>' : '<span style="color:red">Inv&aacute;lido</span>';
    if(el.value=='') document.getElementById('cnpjResponse').innerHTML = '';
}