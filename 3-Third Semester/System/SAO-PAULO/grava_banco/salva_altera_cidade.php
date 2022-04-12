<?php
	session_start();
	include('../include/conexao.php');

	$codigo_cidade = $_POST['txtCodigoCidade'];
	$nome = mb_strtoupper(trim($_POST['txtNome']), 'UTF-8');
	$codigo_estado = $_POST['cmbEstado'];
	$ativo = $_POST['chkAtivo'];
	$hora = date("H:i:s");
	$data = date("d/m/Y");

	$testa_codigo = pg_query("SELECT * FROM cidade WHERE codigo_cidade='" . $codigo_cidade . "'");
	$row = pg_num_rows($testa_codigo);
	//COMEÇA A SQL
	$sql = "BEGIN;";

	if($row>0){
		//ALTERA CIDADE
		$sql .= "UPDATE cidade SET codigo_cidade=$codigo_cidade, nome='$nome', codigo_estado='$codigo_estado', ativo='$ativo' ";
		$sql .= "WHERE codigo_cidade=$codigo_cidade ;";
		//SALVA LOG
		$descricao = "ALTERAÇÃO DE DADOS DO CIDADE: $codigo_cidade, NOME: $nome";
		$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
		$sql .= "VALUES ('$descricao',2, 3,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
		//FINALIZA A SQL
		$sql .= "COMMIT;";
		pg_query($sql);
		if($sql){
			echo "Alterado com sucesso";
		}else{
			echo "Não pode ser alterado";
		}
	}else{
		$testa_nome = pg_query("SELECT * FROM cidade WHERE nome = '" . $nome . "'");
		$row = pg_num_rows($testa_nome);
		if($row > 0){
			echo "A CIDADE já está cadastrada!";
		}else{
			//VERIFICA ÚLTIMA CIDADE
			$select_codigo = pg_query("SELECT MAX (codigo_cidade) FROM cidade"); //PEGA O ULTIMO CODIGO DA TABELA
			$codigo_cidade = pg_fetch_array($select_codigo);
			$codigo_cidade = $codigo_cidade[0] + 1; //ACRESCENTA 1 NO CODIGO
			//SALVA CIDADE
			$sql .= "INSERT INTO cidade (codigo_cidade, nome, codigo_estado, ativo) ";
			$sql .= "VALUES($codigo_cidade, '$nome', '$codigo_estado', '$ativo');";
			//SALVA LOG
			$descricao = "CADASTRO DE DADOS DO CIDADE: $codigo_cidade, NOME: $nome";
			$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
			$sql .= "VALUES ('$descricao', 1, 3,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
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