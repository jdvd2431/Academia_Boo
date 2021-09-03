alerta=document.getElementById("error").value;
function alerta(alerta) {
    if (alerta == "error") {
        location.href = "menu_Vendedor.jsp";
    } else if (value == "Comprador") {
        location.href = "menu_Comprador.jsp";
    } else {
        alert("no existe");
    }
    if(value != "Vendedor"){
        location.href = "menu_Vendedor.jsp";
    } else if (value == "Comprador") {
        location.href = "menu_Comprador.jsp";
    } else if(value != "Comprador"){
        location.href = "menu_Comprador.jsp";
        
    }else{
        alert("no existe");
    }
}


