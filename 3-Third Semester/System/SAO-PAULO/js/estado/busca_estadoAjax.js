function busca_estadoAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
					if(estado == ""){
						document.getElementById("formEstado").reset();
						document.getElementById("cmbEstado").value = "";
						retorna_codigo('estado', 'codigo_estado', 'txtCodigoEstado');
					}else{
						//CAMPOS
						document.getElementById("txtCodigoEstado").value = res[1];
						document.getElementById("txtNome").value = res[2];
						document.getElementById("txtSigla").value = res[3];
						document.getElementById("chkAtivo").value = res[4];
						//ATIVO
						if(res[4] == "t"){
							document.formEstado.chkAtivo.checked = true;
						}else{
							document.formEstado.chkAtivo.checked = false;
						}
					}
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
        estado = document.getElementById("cmbEstado").value;

        dados = 'estado=' + estado;
        
		ajax.open('POST','consulta/estado/preenche_estado_cadastro.php',true);
		ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
    }
}