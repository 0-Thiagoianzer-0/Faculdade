<?php
    include('../include/conexao.php'); 
    session_start();

    if(isset($_POST['atualiza_tabela_produto'])){
        atualiza_tabela_produto();
    }
	
    if(isset($_POST['inserir_produto'])){
        $codigo_produto = $_POST['cmbProduto'];
		$consulta = pg_query("SELECT nome FROM produto where codigo_produto=$codigo_produto");
		$nome_produto = pg_fetch_assoc($consulta);
		$_SESSION['ordem_produto']['produto'][] = array($codigo_produto, $nome_produto['nome']);
    }
	
    if(isset($_POST['remover_produto'])){
        $indice_produto = $_POST['txtIndiceProduto'];
		unset($_SESSION['ordem_produto']['produto'][$indice_produto]);
		echo "|!SUCESSO!|";
    }
	
	if(isset($_POST['limpar'])){
		unset($_SESSION['ordem_produto']['produto']);
	}
	
    function atualiza_tabela_produto(){
        if(isset($_SESSION['ordem_produto']['produto'])){
            foreach($_SESSION['ordem_produto']['produto'] as $indice_produto=> $produto){
                $resultado .= "|" . $indice_produto;
				$resultado .= "|" . $produto[0];
				$resultado .= "|" . $produto[1];
            }
        }
        echo $resultado;
    }
?>