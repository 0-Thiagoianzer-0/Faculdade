<?php 
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Inicial</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="screen" href="css/cabecalho.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:300italic' rel='stylesheet' type='text/css'>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/tms-0.4.1.js"></script>
        <script src="js/dropdown.js"></script>
        <style>
            .foto-capa{
                width: 100%;
                padding: 50px;
                background: url("./images/capa.jpg");
                background-size: cover;
                background-position: center;
            }
        </style>
        <script>
        $(document).ready(function(){
            $('.slider')._TMS({
                show:0,
                pauseOnHover:false,
                prevBu:false,
                nextBu:false,
                playBu:'.play_stop',
                duration:1000,
                preset:'fade',
                pagination:true,
                pagNums:false,
                slideshow:8000,
                numStatus:false,
                banners:'fade',
                waitBannerAnimation:false,
                progressBar:'<div class="progbar"></div>',
                interval:"3",
                blocksX:"1",
                blocksY:"1",
                easing:"easeInExpo",
                way:"lines",
                anim:"fade"
            });
        });
        </script>
    </head>
    
    <body>
        <?php
            $PaginaAtual = "Inicial";
            include "include/cabecalho.php";
			echo "<div class='foto-capa'>";
				require("calendario.html");
			echo "</div>";
		?>
    </body>
</html>