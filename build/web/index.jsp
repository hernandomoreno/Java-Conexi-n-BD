<%-- 
    Document   : index
    Created on : 9/07/2024, 11:18:29 a. m.
    Author     : Moreino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                            <input type="text" name="txtnombre" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Nombres">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="colFormLabel" class="col-sm-2 col-form-label-sm">Email</label>
                        <div class="col-sm-10">
                            <input type="email" name="txtemail" class="form-control form-control-sm" id="colFormLabelSm" placeholder="E-Mail">
                        </div>
                    </div>

                     <br>
                     
                     <input type="submit" class="btn btn-primary" name="accion" value="Ingresar">
                   </form>
                </div>
                
              <div class="col">
                
              </div>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
