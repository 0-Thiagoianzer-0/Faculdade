function busca_pessoaAjax(){
    ajax=IniciaAjax();
    if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    var res = ajax.responseText.split("|");
                    //CAMPOS
                    document.getElementById("txtCodigoPessoa").value = res[1];
                    if(res[2] == "F"){
                        document.formPessoa.radFisica.checked = true;
						document.getElementById("txtCpf").value = res[4];
                    }else{
                        document.formPessoa.radJuridica.checked = true;
						document.getElementById("txtCnpj").value = res[4];
                    }
                    document.getElementById("txtNomeRazaoSocial").value = res[3];
                    document.getElementById("txtIdentidade").value = res[5];
                    document.getElementById("cmbOrgaoEmissor").value = res[6];
                    document.getElementById("txtTituloEleitor").value = res[7];
                    if(res[8] == "F"){
                        document.formPessoa.radFeminino.checked = true;
                    }else if(res[8] == "M"){
                        document.formPessoa.radMasculino.checked = true;
                    }else{
                        document.formPessoa.radFeminino.checked = false;
                        document.formPessoa.radMasculino.checked = false;
                    }
                    document.getElementById("txtNomeFantasia").value = res[9];
                    document.getElementById("txtNomeResponsavel").value = res[10];
                    document.getElementById("cmbEstado").value = res[11];
                    document.getElementById("txtIe").value = res[12];
                    document.getElementById("txtInscricaoMunicipal").value = res[13];
                    document.getElementById("cmbCidade").value = res[14];
					document.getElementById("txtCep").value = res[15];
                    document.getElementById("txtEndereco").value = res[16];
                    document.getElementById("txtNumero").value = res[17];
                    document.getElementById("txtComplemento").value = res[18];
                    document.getElementById("txtBairro").value = res[19];
                    document.getElementById("txtTelefone").value = res[20];
                    document.getElementById("txtTelefoneAdicional").value = res[21];
                    document.getElementById("txtObservacao").value = res[22];
                    document.getElementById("chkAtivo").value = res[23];
                    //ATIVO
                    if(res[23] == "t"){
                        document.formPessoa.chkAtivo.checked = true;
                    }else{
                        document.formPessoa.chkAtivo.checked = false;
                    }
                }else{
                    alert(ajax.statusText);
                }
            }
        }
        pessoa = document.getElementById("cmbPessoa").value;

        dados = 'pessoa=' + pessoa;
		
		if(pessoa == ""){
			limpar();
		}
        
        ajax.open('POST','consulta/pessoa/preenche_pessoa_cadastro.php',true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        ajax.send(dados);
    }
}