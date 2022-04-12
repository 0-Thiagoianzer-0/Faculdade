function limpar(){
	document.getElementById("formTipoProduto").reset();
	document.getElementById('divBotao').style.display = 'block';
	document.getElementById('divBuscar').style.display = 'none';
	document.getElementById('txtDescricao').value = "";
	document.getElementById('chkAtivo').checked = "true";
}