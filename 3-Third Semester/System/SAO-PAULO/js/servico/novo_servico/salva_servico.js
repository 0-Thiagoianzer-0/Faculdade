function salvaservico(){
    ajax = IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){ 
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var resposta = ajax.responseText;
                    document.getElementById("aviso").innerHTML = resposta;
                    document.getElementById("aviso").style.display ='block';
                    setTimeout("document.getElementById('aviso').style.display='none'", 8000);
                    document.getElementById("aviso").innerHTML = resposta;
					enviar.click();
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
		codigo_servico = document.getElementById("txtCodigoServico").value;
		codigo_pessoa = document.getElementById("cmbPessoa").value;
		codigo_prioridade = document.getElementById("cmbPrioridade").value;
		tabela = document.getElementById("tabela_produto").innerHTML;
		prazo = document.getElementById("txtPrazo").value;
		valor = document.getElementById("txtValor").value;
		descricao = document.getElementById("txtDescricao").value;
		anexo = document.forms["formServico"].elements["chkAnexo"];
        if(anexo.checked){
            anexo = 1;
        }else{
            anexo = 0;
		}
		
        dados = '&txtCodigoServico=' + codigo_servico + '&cmbPessoa=' + codigo_pessoa + '&cmbPrioridade=' + codigo_prioridade +
			'&txtPrazo=' + prazo + '&txtValor=' + valor + '&txtDescricao=' + descricao + '&chkAnexo=' + anexo;
		
        if(codigo_servico == '' || codigo_pessoa == '' || codigo_prioridade == '' || tabela == '' || prazo == '' || valor == '' || 
		   	descricao == ''){
            document.getElementById("aviso").style.display = 'block';
            setTimeout("document.getElementById('aviso').style.display='none'", 8000);
            document.getElementById("aviso").innerHTML = 'Preencha todos os campos!';
        }else{
            ajax.open('POST', 'grava_banco/salva_servico.php', true);
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            ajax.send(dados);
			//limpar();
        }
    }
}