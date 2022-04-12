<?php    
	include('../include/conexao.php'); 
	session_start();
	
	$codigo_servico = $_POST['txtCodigoServico'];
	
	$sql = "SELECT codigo_servico_arquivo, nome, extensao, diretorio, data, hora ";
	$sql .= "FROM servico_arquivo ";
	$sql .= "WHERE codigo_servico = $codigo_servico ";
	
	$query = pg_query($sql);
	while($resultado = pg_fetch_assoc($query)){
		$dados .= "|" . $resultado['codigo_servico_arquivo'];
		$dados .= "|" . $resultado['nome'];
		$dados .= "|" . $resultado['extensao'];
		$dados .= "|" . strftime("%d/%m/%Y", strtotime($resultado['data']));
		$dados .= "|" . $resultado['hora'];
		//MONTA CAMINHO DOWNLOAD
		$diretorio = $resultado['diretorio'];
		$nome = $resultado['nome'];
		$extensao = $resultado['extensao'];
		$caminho = "/E-PROT/ANEXOS/".$diretorio.$nome.$extensao;
		$dados .= "|" . $caminho;
	}

	//RETORNA PARA O AJAX OS VALORES
	echo "$dados";
?>