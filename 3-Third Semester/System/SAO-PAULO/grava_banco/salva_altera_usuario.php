<?php
	session_start();
	include('../include/conexao.php');

	$codigo_usuario = $_POST['txtCodigoUsuario'];
	$codigo_pessoa = $_POST['cmbPessoa'];
	$email = $_POST['txtEmail'];
	$senha = $_POST['txtSenha'];
	$senha = md5($senha);
	$ativo = $_POST['chkAtivo'];
	$hora = date("H:i:s");
	$data = date("d/m/Y");

	$testa_codigo = pg_query("SELECT * FROM usuario WHERE codigo_usuario='" . $codigo_usuario . "'");
	$row = pg_num_rows($testa_codigo);
	//COMEÇA A SQL
	$sql = "BEGIN;";

	if($row>0){
		$testa_pessoa = pg_query("SELECT * FROM usuario WHERE codigo_pessoa=$codigo_pessoa AND codigo_usuario <> $codigo_usuario");
		$row = pg_num_rows($testa_pessoa);
		if($row > 0){
			echo "A PESSOA já possuí login!";
		}else{
			//ALTERA USUÁRIO
			$sql .= "UPDATE usuario SET codigo_usuario=$codigo_usuario, codigo_pessoa=$codigo_pessoa, email='$email', senha='$senha', ";
			$sql .= "ativo='$ativo' ";
			$sql .= "WHERE codigo_usuario=$codigo_usuario ;";
			//SALVA LOG
			$descricao = "ALTERAÇÃO DE DADOS DO USUÁRIO: $codigo_usuario";
			$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
			$sql .= "VALUES ('$descricao', 2, 6,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
			//FINALIZA A SQL
			$sql .= "COMMIT;";
			pg_query($sql);
			if($sql){
				echo "Alterado com sucesso";
			}else{
				echo "Não pode ser alterado";
			}
		}
	}else{
		$testa_pessoa = pg_query("SELECT * FROM usuario WHERE codigo_pessoa = '" . $codigo_pessoa . "'");
		$row = pg_num_rows($testa_pessoa);
		if($row > 0){
			echo "A PESSOA já possuí login!";
		}else{
			//VERIFICA ÚLTIMO USUÁRIO
			$select_codigo = pg_query("SELECT MAX (codigo_usuario) FROM usuario"); //PEGA O ULTIMO CODIGO DA TABELA
			$codigo_usuario = pg_fetch_array($select_codigo);
			$codigo_usuario = $codigo_usuario[0] + 1; //ACRESCENTA 1 NO CODIGO
			//SALVA USUÁRIO
			$sql .= "INSERT INTO usuario (codigo_usuario, codigo_pessoa, email, senha, ativo) ";
			$sql .= "VALUES($codigo_usuario, $codigo_usuario, '$email', '$senha', '$ativo');";
			//SALVA LOG
			$descricao = "CADASTRO DE DADOS DO USUÁRIO: $codigo_usuario";
			$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
			$sql .= "VALUES ('$descricao', 1, 6,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
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