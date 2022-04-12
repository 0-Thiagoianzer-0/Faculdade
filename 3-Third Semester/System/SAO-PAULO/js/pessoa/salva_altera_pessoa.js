function salvapessoa(){
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
        codigo_pessoa = document.getElementById("txtCodigoPessoa").value;
        vfisica = document.forms["formPessoa"].elements["radFisica"];
        if(vfisica.checked){
            tipo_pessoa = "F";
        }else{
            tipo_pessoa = "J";
        }
        nome_razao_social = document.getElementById("txtNomeRazaoSocial").value;
		cpf = document.getElementById("txtCpf").value;
		cnpj = document.getElementById("txtCnpj").value;
		if(cpf != ""){
			cpf_cnpj = cpf;
			valida_cpf(cpf);
		}else{
			cpf_cnpj = cnpj;
			valida_cnpj(cnpj);
		}
        identidade = document.getElementById("txtIdentidade").value;
        codigo_orgao_emissor = document.getElementById("cmbOrgaoEmissor").value;
        titulo_eleitor = document.getElementById("txtTituloEleitor").value;
        feminino = document.forms["formPessoa"].elements["radFeminino"]; //Sexo Feminino
        masculino = document.forms["formPessoa"].elements["radMasculino"]; //Sexo Masculino
        if(feminino.checked){
            sexo = "F";
        }else if(masculino.checked){
            sexo = "M";
        }else{
            sexo = "";
        }
        nome_fantasia = document.getElementById("txtNomeFantasia").value;
        responsavel = document.getElementById("txtNomeResponsavel").value;
        codigo_estado = document.getElementById("cmbEstado").value;
        inscricao_estadual = document.getElementById("txtIe").value;
        inscricao_municipal =  document.getElementById("txtInscricaoMunicipal").value;
        codigo_cidade = document.getElementById("cmbCidade").value;
		cep = document.getElementById("txtCep").value;
        endereco = document.getElementById("txtEndereco").value;
        numero = document.getElementById("txtNumero").value;
        complemento = document.getElementById("txtComplemento").value;
        bairro = document.getElementById("txtBairro").value;
        telefone = document.getElementById("txtTelefone").value;
        telefone_adicional = document.getElementById("txtTelefoneAdicional").value;
        observacao = document.getElementById("txtObservacao").value;
        ativo = document.forms["formPessoa"].elements["chkAtivo"];
        if(ativo.checked){
            ativo = 1;
        }else{
            ativo = 0;
        }

        //Monta Query String
        dados = '&txtCodigoPessoa=' + codigo_pessoa + '&radTipoPessoa=' + tipo_pessoa + '&txtNomeRazaoSocial=' + nome_razao_social +
			'&txtCpfCnpj=' + cpf_cnpj + '&txtIdentidade=' + identidade + '&cmbOrgaoEmissor=' + codigo_orgao_emissor + '&txtTituloEleitor=' +
			titulo_eleitor + '&radSexo=' + sexo + '&txtNomeFantasia=' + nome_fantasia + '&txtNomeResponsavel=' + responsavel +
			'&cmbEstado=' + codigo_estado + '&txtIe=' + inscricao_estadual + '&txtInscricaoMunicipal=' + inscricao_municipal +
			'&cmbCidade=' + codigo_cidade + '&txtCep=' + cep + '&txtEndereco=' + endereco + '&txtNumero=' + numero + '&txtComplemento=' +
			complemento + '&txtBairro=' + bairro + '&txtTelefone=' + telefone + '&txtTelefoneAdicional=' + telefone_adicional +
			'&txtObservacao=' + observacao + '&chkAtivo=' + ativo;
		
        if(tipo_pessoa == '' || nome_razao_social == '' || cpf_cnpj == '' || codigo_cidade == '' || cep == '' || endereco == '' ||
		   	numero == '' || bairro == '' || telefone == '') {  //Teste Para Ver se os Campos Foram Preenchidos
            document.getElementById("aviso").style.display = 'block';
            setTimeout("document.getElementById('aviso').style.display='none'", 8000);
            if(!valida_cpf && cpf != ''){
				document.getElementById("aviso").innerHTML = 'Informe um CPF válido!';
			}else if(!valida_cnpj && cnpj != ''){
				document.getElementById("aviso").innerHTML = 'Informe um CNPJ válido!';
            }else{
                document.getElementById("aviso").innerHTML = 'Preencha todos os campos!'; //Evita que o Usuário Deixe os Campos em Branco
            }
        }else{
            //Faz a Requisição e Envio pelo Método POST
            ajax.open('POST', 'grava_banco/salva_altera_pessoa.php', true);
            ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            ajax.send(dados);

            //Deixa os Campos Vazios
            limpar();
        }
    }
}