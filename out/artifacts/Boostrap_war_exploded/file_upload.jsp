
<!doctype html>
<html lang="en">
<div class="container">
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <title>File upload</title>
</head>
<body>


<div class="col-lg-6 col-sm-6 col-12">
    <h4>File Upload</h4>
    <form class="form-inline center-block well" action="/upload" method="POST" enctype="multipart/form-data">
        <div class="input-group">
            <label id="browsebutton" class="btn btn-default input-group-addon" for="my-file-selector" style="background-color:white">
                <input id="my-file-selector" type="file" name="file" style="display:none;">
                Browse...
            </label>
            <input id="label" type="text" class="form-control" readonly="">
        </div>
        <button type="submit" class="btn btn-primary">Upload</button>
        <span class="help-block">
</span>

    </form>
</div>
</body>
</div>
<script>
    $(document).ready(function(){
        $('#browsebutton :file').change(function(e){
            var fileName = e.target.files[0].name;
            $("#label").attr('placeholder',fileName)
        });
    });


</script>
</html>
