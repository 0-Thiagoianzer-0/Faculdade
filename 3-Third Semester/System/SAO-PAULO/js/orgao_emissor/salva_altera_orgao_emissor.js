function salvaorgaoemissor(){
    ajax = IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){ 
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var resposta = ajax.responseText;
                    document.getElementById("aviso").innerHTML = resposta;
                    document.getElementById("aviso").style.display ='block';
                    setTimeout("document.getElementById('aviso').style.display='none'", 8000);
                    //Passa a resposta para a div aviso
                    document.getElementById("aviso").innerHTML = resposta;         
                }else{
                    alert(ajax.statusText);
                }
            }
        }

        //Coloca os Valores dos Campos nas Variaveis
        codigo_orgao_emissor = document.getElementById("txtCodigoOrgaoEmissor").value;
        nome = document.getElementById("txtNome").value;
		sigla = document.getElementById("txtSigla").value;
        ativo = document.forms["formOrgaoEmissor"].elements["chkAtivo"];
        if(ativo.checked){
            ativo = 1;
        }else{
            ativo = 0;
        }

        //Monta Query String
        dados = '&txtCodigoOrgaoEmissor=' + codigo_orgao_emissor + '&txtNome=' + nome + '&txtSigla=' + sigla + '&chkAtivo=' + ativo;
		
        if(codigo_orgao_emissor == '' || nome == '' || sigla == ''){  //Teste Para Ver se os Campos Foram Preenchidos
            document.getElementById("aviso").style.display = 'block';
            setTimeout("document.getElementById('aviso').style.display='none'", 8000);
            document.getElementById("aviso").innerHTML = 'Preencha todos os campos!'; //Evita que o Usuário Deixe os Campos em Branco
        }else{
            //Faz a Requisição e Envio pelo Método POST
            ajax.open('POST', 'grava_banco/salva_altera_orgao_emissor.php', true);
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            ajax.send(dados);

            //Deixa os Campos Vazios
            limpar();
        }
    }
}