<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Mantenedores</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Inicio</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Mantenedor Alumno <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="insertAlumno">Insertar Alumno</a></li>
          <li><a href="/">Listar Alumnos</a></li>
          <li><a href="BuscarRut">Buscar Alumno</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
 
	<div class="container">
	 <c:choose>
	  	<c:when test="${mode == 'ALUMNO_VIEW' }">
		  	<table class="table table-hover">
		    <thead>
		      <tr>
		      	<th>ID</th>
		        <th>Rut</th>
		        <th>Nombre</th>
		        <th>Apellido</th>
		        <th>Fecha Nacimiento</th>
		        <th>Editar</th>
		        <th>Eliminar</th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    	<c:forEach var="alumno" items="${alumnoObject}" >
		    		<tr>
		    			<td>${alumno.id}</td>
		    			<td>${alumno.rut}-${alumno.dv}</td>
		    			<td>${alumno.nombre}</td>
		    			<td>${alumno.apellido}</td>
		    			<td>${alumno.fechNac}</td>
		    			<td><a href="updateAlumno?id=${alumno.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
		    			<td><a href="borrarAlumno?id=${alumno.id}"><div class="glyphicon glyphicon-trash"></div></a></td>
		    		</tr>
		    	</c:forEach>
		    </tbody>
		   
		  </table>
  		</c:when>
  		
  		<c:when test="${mode=='ALUMNO_EDIT' || mode == 'ALUMNO_NEW'}">
  			<form action="saveAlumno" method="POST">
  			<input type="hidden" class="form-control" value="${alumno.id}" name="id" id="id">
  			 <div class="form-group">
			    <label for="rut">Rut:</label>
			    <input type="text" class="form-control" value="${alumno.rut}" name="rut" id="rut">
			  </div>
			  <div class="form-group">
			    <label for="nombre">DV:</label>
			    <input type="text" class="form-control" value="${alumno.dv}" name="dv" id="dv">
			  </div>
			  <div class="form-group">
			    <label for="nombre">Nombres:</label>
			    <input type="text" class="form-control" value="${alumno.nombre}" name="nombre" id="nombre">
			  </div>
			  <div class="form-group">
			    <label for="apellido">Apellidos:</label>
			    <input type="text" class="form-control" value="${alumno.apellido}" name="apellido" id="apellido">
			  </div>
			  <div class="form-group">
			    <label for="fechNac">Fecha Nacimiento:</label>
			    <input type="date" class="form-control" value="${alumno.fechNac}" name="fechNac" id="fechNac">
			  </div>
			  <button type="submit" class="btn btn-default">Editar</button>
			</form>
  		</c:when>
  		
  		<c:when test="${mode=='ALUMNO_FIND' }">
  			<form class="navbar-form navbar-left" action="traerAlumno" method="POST">
		      <div class="form-group">
		        <input type="text" class="form-control" name="rutBuscar" placeholder="Ej: 17667854-2">
		      </div>
		      <button type="submit" class="btn btn-default">Buscar</button>
		      
		      <table class="table table-hover">
		    <thead>
		      <tr>
		      	<th>ID</th>
		        <th>Rut</th>
		        <th>Nombre</th>
		        <th>Apellido</th>
		        <th>Fecha Nacimiento</th>
		        <th>Editar</th>
		        <th>Eliminar</th>
		      </tr>
		    </thead>
		    <tbody>
		       		<tr>
		    			<td>${alumno.id}</td>
		    			<td>${alumno.rut}-${alumno.dv}</td>
		    			<td>${alumno.nombre}</td>
		    			<td>${alumno.apellido}</td>
		    			<td>${alumno.fechNac}</td>
		    			<td><a href="updateAlumno?id=${alumno.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
		    			<td><a href="borrarAlumno?id=${alumno.id}"><div class="glyphicon glyphicon-trash"></div></a></td>
		    		</tr>
		    </tbody>
		   
		  </table>
		      
		    </form>
  		</c:when>
  	</c:choose>
  
</div>

</body>
</html>
