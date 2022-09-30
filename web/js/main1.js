
$(function(){
     
    $('#frm-registro').validate({
        rules : {
            Nombres : {
                required : true,
                minlength : 10,
                maxlength : 15
            },
            Apellidos : {
                required : true,
                minlength : 10,
                maxlength : 15
            },
            Identificasion : {
                required : true
            },
            CorreoElectronico : {
                required : true ,
                email : true
            },
            password : {
                required : true,
                minlength : 8,
                maxlength : 20
            }
            
        },
        messages : {
            Nombres : {
                required : "Campo obligatorio",
                 minlength : "Minimo 10 caracteres",
                maxlength : "Maximo 15 caracteres"
                
            },
            Apellidos : {
                required :"Campo Obligatorio",
                 minlength : "Minimo 10 caracteres",
                maxlength : "Maximo 15 caracteres"
            },
            password : {
                required :"Campo Obligatorio",
                 minlength : "Minimo 8  caracteres",
                maxlength : "Maximo 20 caracteres"
            }
        }
    });
    $('#frm-login').validate({
        rules : {
            CorreoElectronico : {
                required : true
            },
            password : {
                required : true
            }
        },
        messages : {
            CorreoElectronico : {
                required : "Campo Obligatorio"
            },
            password : {
                required : "Ingresa una contraseña"
            }
        }
    }); 
    


});


