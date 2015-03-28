<!DOCTYPE html>
<%@include file="/Util/Cabecalho.jsp"%>
<html>
<head>

  
  <meta charset="utf-8">
  <title>Meus Filmes Assistidos</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  

  <!-- Main Style -->
  <link rel="stylesheet" href="css/style.css"> 
  
  <!-- Color Style -->
  <link rel="stylesheet" href="css/skins/colors/red.css" name="colors">
  
  <!-- Layout Style -->
  <link rel="stylesheet" href="css/layout/wide.css" name="layout">
  
  <!-- Style Switcher Box -->
  <link rel="stylesheet" href="css/switcher/style.css">
  
  <!-- Favicons -->
  <link rel="shortcut icon" href="images/favicon.ico">
  
  

  
  
<script>
$(function() {
    $( "#datepicker" ).datepicker({
        showOn: "button",
        buttonImage: "image/calendario-icon.png",
        buttonImageOnly: true,
        dateFormat: 'dd/mm/yy',
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
    });
});
</script>
  
</head>
<body>

  <%--<div id="wrap" class="boxed">--%>
  
   <header>
     <div class="top-bar">
       <div class="container clearfix">
        <div class="slidedown">
        
         <div class="eight columns">
           <div class="phone-mail">
             <h3>Meus Filmes Assistidos</h3>
           </div><!-- End phone-mail -->
         </div>
         <div class="eight columns">
           <div class="social">
           <a href="index.html#"><i class="social_icon-twitter s-14"></i></a>
           <a href="index.html#"><i class="social_icon-facebook s-18"></i></a>
           <a href="index.html#"><i class="social_icon-dribbble s-18"></i></a>
           <a href="index.html#"><i class="social_icon-appstore s-18"></i></a>
           <a href="index.html#"><i class="social_icon-amazon s-18"></i></a>
           <a href="index.html#"><i class="social_icon-rss s-18"></i></a>
           </div>
          </div><!-- End social-icons -->
          
         </div><!-- End slidedown -->
       </div><!-- End Container -->
       
     </div><!-- End top-bar -->
     
   </header><!-- <<< End Header >>> -->
     
     <div style=" margin-top: 20px;  margin-left: 38%; width: 250px; height: 160px;">
	     	<form action="includFilmAction" method="post" enctype="multipart/form-data">
		          <table>
		          	<tr>
		          		<td><label>Nome: </label></td>
		          		<td><input type="text" name="filme.nome" style="padding:5px 10px; width:89%;"/></td>
		          	</tr>
		          	<tr>
		          		<td><label>Pais: </label></td>
		          		<td><input type="text" name="filme.pais" style="padding:5px 10px; width:89%;"/></td>
		          	</tr>
		          	<tr style="padding: 5px;">
		          		<td><label>Ano: </label></td>
		          		<td><select name="filme.ano" style="padding:5px 10px; width:58%;">
		          				<%for(int i=0; i < 36; i++){%>
		          					<option value="<%=1980 + i%>"><%=1980 + i%></option>
		          				<%}%> 
			                 </select></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;">
		          		<td><label>Data: </label></td>
		          		<td><input type="text" id="datepicker" name="historicoFilme.dataVisualizacao" style="padding:5px 10px; width:50%;"/></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;">
		          		<td><label>Local: </label></td>
		          		<td><input type="text" name="historicoFilme.local" style="padding:5px 10px; width:89%;"/></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;">
		          		<td><label>Gênero: </label></td>
		          		<td><select name="filme.genero" style="padding:5px 10px; width:58%;">
		          			<option value="Ação">Ação</option>
		          			<option value="Aventura">Aventura</option>
		          			<option value="Drama">Drama</option>
		          			<option value="Ficção">Ficção</option>
		          			<option value="Comédia">Comédia</option>
		          			<option value="Romance">Romance</option>
		          			<option value="Comédia Romantica">Comédia Romantica</option>
		          			<option value="Suspense">Suspense</option>
		          			<option value="Terror">Terror</option>
			                 </select></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;">
		          		<td><label>Nota: </label></td>
		          		<td><select name="filme.nota" style="padding:5px 10px; width:58%;">
		          			<option value="0">0</option>
		          			<option value="1">1</option>
		          			<option value="2">2</option>
		          			<option value="3">3</option>
		          			<option value="4">4</option>
		          			<option value="5">5</option>
		          			
			                 </select></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;" valign="top">
		          		<td valign="top"><label>Comentário:</label></td>
		          		<td><textarea cols="50" id="" name="historicoFilme.comentario" rows="5"></textarea></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;" valign="top">
		          		<td valign="top"><label>Companhias:</label></td>
		          		<td><textarea cols="50" id="" name="historicoFilme.companhias" rows="5"></textarea></td>
		          	</tr>
		          	
		          	<tr style="padding: 5px;">
		          		<td><label>Imagem: </label></td>
		          		<td><input type="file" name="myFile" style="padding:5px 10px; width:89%;"/></td>
		          	</tr>
		          	
		      
		          	<tr>
		          		<td></td>
		          		<td><input type="submit" value="Entrar" class="button small color"  style="width: 260px;"/></td>
		          	</tr>
		          </table>
	          </form>
     </div>
   
</body>
</html>