<%-- 
    Document   : PersonNew
    Created on : 24/07/2024, 3:19:48 p. m.
    Author     : Moreino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container text-center container-fluid">
 
            <div class="row">
              <div class="col">
              </div>
                
              <div class="col">
                  <br>
                 <h2>Bienvenido al Sistema!</h2>
                 <form action="Controlador"> 
                    <div class="row mb-3">
                        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Nombres</label>
                        <div class="col-sm-10">
                            <input type="text" name="newnombre" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Nombres">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="colFormLabel" class="col-sm-2 col-form-label-sm">Email</label>
                        <div class="col-sm-10">
                            <input type="email" name="newemail" class="form-control form-control-sm" id="colFormLabelSm" placeholder="E-Mail">
                        </div>
                    </div>

                     <br>
                     
                     <input type="submit" class="btn btn-primary" name="accion" value="Guardar">
                     <input type="submit" class="btn btn-primary" name="accion" value="Cancelar">
                     
                   </form>
                   
                </div>
                
              <div class="col">
                
              </div>
            </div>
        </div>
    </body>
</html>
