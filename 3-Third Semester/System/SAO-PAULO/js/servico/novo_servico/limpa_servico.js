function limpar(){
	document.getElementById("formServico").reset();
	document.getElementById("txtDescricao").value = "";
	document.getElementById('chkAnexo').value = 0;
	document.getElementById("divAnexo").style.display = 'none';
	limpar_tabela();
	retorna_codigo('servico', 'codigo_servico', 'txtCodigoServico');
}