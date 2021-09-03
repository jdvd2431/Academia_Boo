/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function redireccion(value){
    if (value==="Estudiante"){
        location.href="MenuEstudiante.jsp";
   
    }else if(value==="Profesor"){
        location.href="MenuProfesor.jsp";
        
    }else if(value==="Administrador") 
        location.href="Menu.jsp";
   
    
    
    
    
    
    
}

