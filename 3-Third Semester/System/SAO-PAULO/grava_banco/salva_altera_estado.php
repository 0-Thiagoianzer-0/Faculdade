<?php
	session_start();
	include('../include/conexao.php');

	$codigo_estado = $_POST['txtCodigoEstado'];
	$nome = mb_strtoupper(trim($_POST['txtNome']), 'UTF-8');
	$sigla = mb_strtoupper(trim($_POST['txtSigla']), 'UTF-8');
	$ativo = $_POST['chkAtivo'];
	$hora = date("H:i:s");
	$data = date("d/m/Y");

	$testa_codigo = pg_query("SELECT * FROM estado WHERE codigo_estado='" . $codigo_estado . "'");
	$row = pg_num_rows($testa_codigo);
	//COMEÇA A SQL
	$sql = "BEGIN;";

	if($row>0){
		//ALTERA ESTADO
		$sql .= "UPDATE estado SET codigo_estado=$codigo_estado, nome='$nome', sigla='$sigla', ativo='$ativo' ";
		$sql .= "WHERE codigo_estado=$codigo_estado ;";
		//SALVA LOG
		$descricao = "ALTERAÇÃO DE DADOS DO ESTADO: $codigo_estado, NOME: $nome";
		$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
		$sql .= "VALUES ('$descricao',2, 2,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
		//FINALIZA A SQL
		$sql .= "COMMIT;";
		pg_query($sql);
		if($sql){
			echo "Alterado com sucesso";
		}else{
			echo "Não pode ser alterado";
		}
	}else{
		$testa_nome = pg_query("SELECT * FROM estado WHERE nome = '" . $nome . "'");
		$row = pg_num_rows($testa_nome);
		if($row > 0){
			echo "O ESTADO já está cadastrado!";
		}else{
			//VERIFICA ÚLTIMO ESTADO
			$select_codigo = pg_query("SELECT MAX (codigo_estado) FROM estado"); //PEGA O ULTIMO CODIGO DA TABELA
			$codigo_estado = pg_fetch_array($select_codigo);
			$codigo_estado = $codigo_estado[0] + 1; //ACRESCENTA 1 NO CODIGO
			//SALVA ESTADO
			$sql .= "INSERT INTO estado (codigo_estado, nome, sigla, ativo) ";
			$sql .= "VALUES($codigo_estado, '$nome', '$sigla', '$ativo');";
			//SALVA LOG
			$descricao = "CADASTRO DE DADOS DO ESTADO: $codigo_estado, NOME: $nome";
			$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
			$sql .= "VALUES ('$descricao', 1, 2,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
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