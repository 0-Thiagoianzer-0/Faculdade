function limpar(){
	document.getElementById("formEstado").reset();
	document.getElementById('divBotao').style.display = 'block';
	document.getElementById('divBuscar').style.display = 'none';
	document.getElementById('chkAtivo').checked = "true";
	retorna_codigo('estado', 'codigo_estado', 'txtCodigoEstado');
}