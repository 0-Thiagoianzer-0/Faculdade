function check_todos(){
	if(document.getElementById('chkTodos').checked){
		cont = 0;
		teste = "sim";
		while(teste == "sim"){
			if(document.getElementById('inputs').getElementsByTagName('input')[cont]){
				document.getElementById('inputs').getElementsByTagName('input')[cont].checked = 1;
			}else{
				teste = "nao";
			}
			cont++;
		}
	}else{
		cont = 0;
		teste = "sim";
		while(teste == "sim"){
			if(document.getElementById('inputs').getElementsByTagName('input')[cont]){
				document.getElementById('inputs').getElementsByTagName('input')[cont].checked = 0;
			}else{
				teste = "nao";
			}
			cont++;
		}
	}
}