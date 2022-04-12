<?php
	session_start();
	include('../include/conexao.php');

	$codigo_produto = $_POST['txtCodigoProduto'];
	$nome = mb_strtoupper(trim($_POST['txtNome']), 'UTF-8');
	$codigo_tipo_produto = $_POST['cmbTipoProduto'];
	$cor = mb_strtoupper(trim($_POST['txtCor']), 'UTF-8');
	$espessura = $_POST['txtEspessura'];
	$observacao = mb_strtoupper(trim($_POST['txtObservacao']), 'UTF-8');
	$ativo = $_POST['chkAtivo'];
	$hora = date("H:i:s");
	$data = date("d/m/Y");

	$testa_codigo = pg_query("SELECT * FROM produto WHERE codigo_produto='" . $codigo_produto . "'");
	$row = pg_num_rows($testa_codigo);
	//COMEÇA A SQL
	$sql = "BEGIN;";

	if($row>0){
		//ALTERA PRODUTO
		$sql .= "UPDATE produto SET codigo_produto=$codigo_produto, nome='$nome', codigo_tipo_produto='$codigo_tipo_produto', ";
		$sql .= "cor='$cor', espessura='$espessura', observacao='$observacao', ativo='$ativo' ";
		$sql .= "WHERE codigo_produto=$codigo_produto ;";
		//SALVA LOG
		$descricao = "ALTERAÇÃO DE DADOS DO PRODUTO: $codigo_produto, NOME: $nome";
		$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
		$sql .= "VALUES ('$descricao',2, 7,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
		//FINALIZA A SQL
		$sql .= "COMMIT;";
		pg_query($sql);
		if($sql){
			echo "Alterado com sucesso";
		}else{
			echo "Não pode ser alterado";
		}
	}else{
		$testa_nome = pg_query("SELECT * FROM produto WHERE nome = '" . $nome . "'");
		$row = pg_num_rows($testa_nome);
		if($row > 0){
			echo "O PRODUTO já está cadastrado!";
		}else{
			//VERIFICA ÚLTIMO PRODUTO
			$select_codigo = pg_query("SELECT MAX (codigo_produto) FROM produto"); //PEGA O ULTIMO CODIGO DA TABELA
			$codigo_produto = pg_fetch_array($select_codigo);
			$codigo_produto = $codigo_produto[0] + 1; //ACRESCENTA 1 NO CODIGO
			//SALVA PRODUTO
			$sql .= "INSERT INTO produto (codigo_produto, nome, codigo_tipo_produto, cor, espessura, observacao, ativo) ";
			$sql .= "VALUES($codigo_produto, '$nome', '$codigo_tipo_produto', '$cor', '$espessura', '$observacao', '$ativo');";
			//SALVA LOG
			$descricao = "CADASTRO DE DADOS DO PRODUTO: $codigo_produto, NOME: $nome";
			$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
			$sql .= "VALUES ('$descricao', 1, 7,{$_SESSION['codigo_usuario']}, '$data', '$hora');";
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