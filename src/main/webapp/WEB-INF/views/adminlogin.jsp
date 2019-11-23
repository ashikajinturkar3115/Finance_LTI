<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <section class="container-fluid">
            <div class="row justify-content-center ">

                <div class="col-4 rounded border bg-white " id="col-Login" >
                            <p class="text-center"><strong>Login Admin</strong></p>
                        
                            <form class="login-form"  method="POST" action="adminlogin">
                                
                                <div class="form-group">
                                    <label >Name</label>
                                    <input type="text" id="adminname" name="adminname" class="form-control" placeholder="Name" required>    
                                </div>
                                <div class="form-group">
                                    <label >Password</label>
                                    <input type="password" class="form-control"  id="adminpassword" name="adminpassword"  placeholder="Password" required>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg">Submit</button>                              
                                </div>
                            </form>
                        </div>
                </div>
            </section>
    </body>
</html>