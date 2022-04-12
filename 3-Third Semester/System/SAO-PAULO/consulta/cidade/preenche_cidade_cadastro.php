<?php 
    header('Content-Type: text/html; charset=utf-8');
    $gmtDate = gmdate("D, d M Y H:i:s");
    header("Expires: {$gmtdate} GMT");
    header("Last-Modified: {$gmtDate} GMT");
    header("Cache-Control: no-cache, must-revalidate");
    header("Progma: no-cache");
    include('../../include/conexao.php');
    $cidade = $_POST['cidade'];
    $preenche=0;

    $consulta = pg_query("SELECT * FROM cidade WHERE codigo_cidade=$cidade");
    $y = pg_fetch_array($consulta);
    //RETORNOS
    $preenche .=  "|" . $y['codigo_cidade'];
    $preenche .=  "|" . $y['nome'];
	$preenche .=  "|" . $y['codigo_estado'];
    $preenche .=  "|" . $y['ativo'];
    
    echo $preenche;
?>