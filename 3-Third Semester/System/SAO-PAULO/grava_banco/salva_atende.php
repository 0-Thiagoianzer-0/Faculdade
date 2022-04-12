<?php
    include('../include/conexao.php'); 
    session_start();
	
	$hora = date("H:i:s");
	$data = date("d/m/Y");

    if(isset($_POST['atende_servico'])){
		$codigo_servico = $_POST['txtCodigo'];
		$codigo_servico_status = 2;
		
		//UPDATE STATUS SERVICO
		$sql = "BEGIN; ";
		$sql .= "UPDATE servico SET codigo_servico_status=$codigo_servico_status ";
		$sql .= "WHERE codigo_servico = $codigo_servico; ";
		//SALVA LOG
		$descricao = "ALTERAÇÃO DO STATUS DO SERVICO: $codigo_servico, STATUS: $codigo_servico_status";
		$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
		$sql .= "VALUES ('$descricao', 2, 9,{$_SESSION['codigo_usuario']}, '$data', '$hora'); ";
		//FINALIZA A SQL
		$sql .= "COMMIT; ";
		pg_query($sql);
		if($sql){
			echo "Alterado com sucesso";
		}else{
			echo "Não pode ser alterado";
		}
    }
	
    if(isset($_POST['conclui_servico'])){
		$codigo_servico = $_POST['txtCodigo'];
		$codigo_servico_status = 3;
		
		//UPDATE STATUS SERVICO
		$sql = "BEGIN; ";
		$sql .= "UPDATE servico SET codigo_servico_status=$codigo_servico_status ";
		$sql .= "WHERE codigo_servico = $codigo_servico; ";
		//SALVA LOG
		$descricao = "ALTERAÇÃO DO STATUS DO SERVICO: $codigo_servico, STATUS: $codigo_servico_status";
		$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
		$sql .= "VALUES ('$descricao', 2, 9,{$_SESSION['codigo_usuario']}, '$data', '$hora'); ";
		//FINALIZA A SQL
		$sql .= "COMMIT; ";
		pg_query($sql);
		if($sql){
			echo "Alterado com sucesso";
		}else{
			echo "Não pode ser alterado";
		}
    }
	
    if(isset($_POST['cancela_servico'])){
		$codigo_servico = $_POST['txtCodigo'];
		$codigo_servico_status = 5;
		
		//UPDATE STATUS SERVICO
		$sql = "BEGIN; ";
		$sql .= "UPDATE servico SET codigo_servico_status=$codigo_servico_status ";
		$sql .= "WHERE codigo_servico = $codigo_servico; ";
		//SALVA LOG
		$descricao = "ALTERAÇÃO DO STATUS DO SERVICO: $codigo_servico, STATUS: $codigo_servico_status";
		$sql .= "INSERT INTO log (descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) ";
		$sql .= "VALUES ('$descricao', 2, 9,{$_SESSION['codigo_usuario']}, '$data', '$hora'); ";
		//FINALIZA A SQL
		$sql .= "COMMIT; ";
		pg_query($sql);
		if($sql){
			echo "Alterado com sucesso";
		}else{
			echo "Não pode ser alterado";
		}
    }
?>