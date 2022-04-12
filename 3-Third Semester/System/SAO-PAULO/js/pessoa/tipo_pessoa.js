function fisica(){
	//DESABILITA
	document.getElementById("divNomeFantasia").style.display = 'none';
	document.getElementById("divResponsavel").style.display = 'none';
	document.getElementById("divEstado").style.display = 'none';
	document.getElementById("divIe").style.display = 'none';
	document.getElementById("divIm").style.display = 'none';
	//HABILITA
	document.getElementById("divIdentidade").style.display = 'block';
	document.getElementById("divOrgaoEmissor").style.display = 'block';
	document.getElementById("divTituloEleitor").style.display = 'block';
	document.getElementById("divSexo").style.display = 'block';
}

function juridica(){
	//DESABILITA
	document.getElementById("divIdentidade").style.display = 'none';
	document.getElementById("divOrgaoEmissor").style.display = 'none';
	document.getElementById("divTituloEleitor").style.display = 'none';
	document.getElementById("divSexo").style.display = 'none';
	//HABILITA
	document.getElementById("divNomeFantasia").style.display = 'block';
	document.getElementById("divResponsavel").style.display = 'block';
	document.getElementById("divEstado").style.display = 'block';
	document.getElementById("divIe").style.display = 'block';
	document.getElementById("divIm").style.display = 'block';
}