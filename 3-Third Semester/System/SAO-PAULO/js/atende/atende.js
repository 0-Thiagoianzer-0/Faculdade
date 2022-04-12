function atendeservico(txtCodigoServico){
    ajax = IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var resposta = ajax.responseText;
					alert(resposta);
                    document.getElementById("aviso").innerHTML = resposta;
                    document.getElementById("aviso").style.display ='block';
                    setTimeout("document.getElementById('aviso').style.display='none'", 8000);
                    document.getElementById("aviso").innerHTML = resposta;
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
		operacao = "atende_servico";
		codigo_servico = txtCodigoServico;
		
        dados = 'atende_servico=' + operacao + '&txtCodigo=' + codigo_servico;
		
		alert(dados);
		
		ajax.open('POST', 'grava_banco/salva_atende.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
    }
}

function concluiservico(txtCodigoServico){
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
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
		operacao = "conclui_servico";
		codigo_servico = txtCodigoServico;
		
        dados = 'conclui_servico=' + operacao + '&txtCodigo=' + codigo_servico;
		
		ajax.open('POST', 'grava_banco/salva_atende.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
    }
}

function cancelaservico(txtCodigoServico){
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
                }else{
                    alert(ajax.statusText);
                }
            }
        }
		
		operacao = "cancela_servico";
		codigo_servico = txtCodigoServico;
		
        dados = 'cancela_servico=' + operacao + '&txtCodigo=' + codigo_servico;
		
		ajax.open('POST', 'grava_banco/salva_atende.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
    }
}