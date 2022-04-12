function limpar(){
	document.getElementById("formProduto").reset();
	document.getElementById("txtObservacao").value = "";
	document.getElementById('divBotao').style.display = 'block';
	document.getElementById('divBuscar').style.display = 'none';
	document.getElementById('chkAtivo').checked = "true";
}