  var ajax;
  function IniciaAjax(){
      var ajax;
        if(window.XMLHttpRequest){  //Mozilla safari e outros
           ajax = new XMLHttpRequest();        
        }else if(window.ActiveXObject){  //IE
            ajax = new ActiveXObject("Msxml2.XMLHTTP"); 
            if(!ajax){
                ajax = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }else{
          alert("Seu servidor não possui suporte a essa aplicação!"); 
         }
         return ajax;  
     } 