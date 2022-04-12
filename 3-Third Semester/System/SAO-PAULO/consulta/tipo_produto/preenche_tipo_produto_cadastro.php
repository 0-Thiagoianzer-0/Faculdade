<?php 
    header('Content-Type: text/html; charset=utf-8');
    $gmtDate = gmdate("D, d M Y H:i:s");
    header("Expires: {$gmtdate} GMT");
    header("Last-Modified: {$gmtDate} GMT");
    header("Cache-Control: no-cache, must-revalidate");
    header("Progma: no-cache");
    include('../../include/conexao.php'); 
    $tipo_produto = $_POST['tipo_produto'];
    $preenche=0;                

    $consulta = pg_query("SELECT * FROM tipo_produto WHERE codigo_tipo_produto=$tipo_produto");
    $y = pg_fetch_array($consulta);
    //RETORNOS
    $preenche .=  "|" . $y['codigo_tipo_produto'];
    $preenche .=  "|" . $y['nome'];
    $preenche .=  "|" . $y['descricao'];
    $preenche .=  "|" . $y['ativo'];
    
    echo $preenche;
?>