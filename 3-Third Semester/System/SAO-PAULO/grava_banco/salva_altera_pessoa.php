<?php
    session_start();
    include('../include/conexao.php');
    
    $codigo_pessoa = $_POST['txtCodigoPessoa'];
    $tipo_pessoa = $_POST['radTipoPessoa'];
    $nome_razao_social = mb_strtoupper($_POST['txtNomeRazaoSocial']);
    $cpf_cnpj = $_POST['txtCpfCnpj'];
    $cpf_cnpj = preg_replace("/\D+/", "", $cpf_cnpj); // remove qualquer caracter não numérico
    $identidade = $_POST['txtIdentidade'];
    $codigo_orgao_emissor = $_POST['cmbOrgaoEmissor'];
    if($codigo_orgao_emissor == ""){
        $codigo_orgao_emissor = "null";
    }
    $titulo_eleitor = $_POST['txtTituloEleitor'];
    $sexo = $_POST['radSexo'];
    $nome_fantasia = mb_strtoupper($_POST['txtNomeFantasia']);
    $responsavel = mb_strtoupper($_POST['txtNomeResponsavel']);
    $codigo_estado = $_POST['cmbEstado'];
    if($codigo_estado == ""){
        $codigo_estado = "null";
    }
    $inscricao_estadual = $_POST['txtIe'];
    $inscricao_estadual = preg_replace("/\D+/", "", $inscricao_estadual); // remove qualquer caracter não numérico
    $inscricao_municipal = $_POST['txtInscricaoMunicipal'];
    $codigo_cidade = $_POST['cmbCidade'];
    if($codigo_cidade == ""){
        $codigo_cidade = "null";
    }
	$cep = $_POST['txtCep'];
    $endereco = mb_strtoupper($_POST['txtEndereco']);
    $numero = $_POST['txtNumero'];
    $complemento = mb_strtoupper($_POST['txtComplemento']);
    $bairro = mb_strtoupper($_POST['txtBairro']);
    $telefone = $_POST['txtTelefone'];
	$telefone = preg_replace("/\D+/", "", $telefone);
    $telefone_adicional = $_POST['txtTelefoneAdicional'];
	$telefone_adicional = preg_replace("/\D+/", "", $telefone_adicional);
    $observacao = mb_strtoupper($_POST['txtObservacao']);
    $ativo = $_POST['chkAtivo'];
    $hora = date("H:i:s");
    $data = date("d/m/Y");

    $testa_codigo = pg_query("SELECT * FROM usuario WHERE codigo_pessoa='" . $codigo_pessoa . "'");
    $row = pg_num_rows($testa_codigo);
    //COMEÇA A SQL
    $sql = "BEGIN;";

    if($row>0){
        //ALTERA PESSOA
        $sql .= "UPDATE pessoa SET codigo_pessoa=$codigo_pessoa, tipo_pessoa='$tipo_pessoa', nome_razao_social='$nome_razao_social', ";
        $sql .= "cpf_cnpj='$cpf_cnpj', identidade='$identidade', codigo_orgao_emissor=$codigo_orgao_emissor, titulo_eleitor='$titulo_eleitor', ";
        $sql .= "sexo='$sexo', nome_fantasia='$nome_fantasia', responsavel='$responsavel', codigo_estado=$codigo_estado, ";
        $sql .= "inscricao_estadual='$inscricao_estadual', inscricao_municipal='$inscricao_municipal', codigo_cidade=$codigo_cidade, ";
        $sql .= "cep='$cep', endereco='$endereco', numero='$numero', complemento='$complemento', bairro='$bairro', telefone='$telefone', ";
        $sql .= "telefone_adicional='$telefone_adicional', observacao='$observacao', ativo='$ativo' ";
        $sql .= "WHERE codigo_pessoa=$codigo_pessoa ;";
        //SALVA LOG
        $descricao = "ALTERAÇÃO DE DADOS DA PESSOA: $codigo_pessoa, NOME: $nome_razao_social";
        $sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
        $sql .= "VALUES ('$descricao', 1, 1,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
        //FINALIZA A SQL
        $sql .= "COMMIT;";
        pg_query($sql);
        if($sql){
            echo "Alterado com sucesso";
        }else{
            echo "Não pode ser alterado";
        }
        pg_close();
    }else{
        $testa_cpf_cnpj = pg_query("SELECT * FROM pessoa WHERE cpf_cnpj = '" . $cpf_cnpj . "'");
        $row = pg_num_rows($testa_cpf_cnpj);
        if($row > 0){
            echo "O CPF/CNPJ já está cadastrado!";
        }else{
            //VERIFICA ÚLTIMA PESSOA
            $select_codigo = pg_query("SELECT MAX (codigo_pessoa) FROM pessoa"); //PEGA O ULTIMO CODIGO DA TABELA
            $codigo_pessoa = pg_fetch_array($select_codigo);
            $codigo_pessoa = $codigo_pessoa[0] + 1; //ACRESCENTA 1 NO CODIGO
            //SALVA PESSOA
            $sql .= "INSERT INTO pessoa (codigo_pessoa, tipo_pessoa, nome_razao_social, cpf_cnpj, identidade, codigo_orgao_emissor, ";
			$sql .= "titulo_eleitor, sexo, nome_fantasia, responsavel, codigo_estado, inscricao_estadual, inscricao_municipal, codigo_cidade, ";
			$sql .= "cep, endereco, numero, complemento, bairro, telefone, telefone_adicional, observacao, ativo) ";
            $sql .= "VALUES($codigo_pessoa, '$tipo_pessoa', '$nome_razao_social', '$cpf_cnpj', '$identidade', $codigo_orgao_emissor, ";
			$sql .= "'$titulo_eleitor', '$sexo', '$nome_fantasia', '$responsavel', $codigo_estado, '$inscricao_estadual', ";
			$sql .= "'$inscricao_municipal', $codigo_cidade, '$cep','$endereco', '$numero', '$complemento', '$bairro', '$telefone', ";
			$sql .= "'$telefone_adicional', '$observacao', '$ativo');";
            //SALVA LOG
            $descricao = "CADASTRO DE DADOS DA PESSOA: $codigo_pessoa, NOME: $nome_razao_social";
            $sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
            $sql .= "VALUES ('$descricao', 1, 1,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
            //FINALIZA A SQL
            $sql .= "COMMIT;";
            pg_query($sql);
            if($sql){
                echo'Cadastrado com sucesso';
            }else{
                echo'Não pode ser Cadastrado'; 
            }
        }
    }
?>