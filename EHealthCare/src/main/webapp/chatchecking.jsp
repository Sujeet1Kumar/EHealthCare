<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="Chatting.js">
  </script>
</head>
<body>

<div class="container" style="text-align:center">
<br><br>
	<textarea style="resize:none" id="chatarea" name="feed" rows="10" cols="80" placeholder="Your Chat will display here" readonly="readonly"></textarea>
    <br><br>
	<input type="text" class="form-control mb-2 mr-sm-2" id="msg" placeholder="Enter Your Message Here" name="email">
    <button type="submit" class="btn btn-primary mb-2" id="button">Send</button>
</div>

</body>
</html>