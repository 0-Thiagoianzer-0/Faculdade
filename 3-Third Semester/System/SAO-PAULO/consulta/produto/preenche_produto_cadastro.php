<?php 
    header('Content-Type: text/html; charset=utf-8');
    $gmtDate = gmdate("D, d M Y H:i:s");
    header("Expires: {$gmtdate} GMT");
    header("Last-Modified: {$gmtDate} GMT");
    header("Cache-Control: no-cache, must-revalidate");
    header("Progma: no-cache");
    include('../../include/conexao.php');
    $produto = $_POST['produto'];
    $preenche=0;

    $consulta = pg_query("SELECT * FROM produto WHERE codigo_produto=$produto");
    $y = pg_fetch_array($consulta);
    //RETORNOS
    $preenche .=  "|" . $y['codigo_produto'];
    $preenche .=  "|" . $y['nome'];
	$preenche .=  "|" . $y['codigo_tipo_produto'];
	$preenche .=  "|" . $y['cor'];
	$preenche .=  "|" . $y['espessura'];
	$preenche .=  "|" . $y['observacao'];
    $preenche .=  "|" . $y['ativo'];
    
    echo $preenche;
?>