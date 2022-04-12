<?php 
    header('Content-Type: text/html; charset=utf-8');
    $gmtDate = gmdate("D, d M Y H:i:s");
    header("Expires: {$gmtdate} GMT");
    header("Last-Modified: {$gmtDate} GMT");
    header("Cache-Control: no-cache, must-revalidate");
    header("Progma: no-cache");
    include('../../include/conexao.php');
    $orgao_emissor = $_POST['orgao_emissor'];
    $preenche=0;

    $consulta = pg_query("SELECT * FROM orgao_emissor WHERE codigo_orgao_emissor=$orgao_emissor");
    $y = pg_fetch_array($consulta);
    //RETORNOS
    $preenche .=  "|" . $y['codigo_orgao_emissor'];
    $preenche .=  "|" . $y['nome'];
	$preenche .=  "|" . $y['sigla'];
    $preenche .=  "|" . $y['ativo'];
    
    echo $preenche;
?>