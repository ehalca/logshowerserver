<html>
<head>
<script src="/logs/resources/js/jquery-2.2.0.min.js"></script>
<script src="/logs/resources/js/stomp.js"></script>
<script src="//cdn.jsdelivr.net/sockjs/1.0.3/sockjs.min.js"></script>
</head>
<body>
<script type="text/javascript">
var socket = new SockJS('/logs/random');
var client = Stomp.over(socket);

client.connect( function(frame) {

  client.subscribe("/data", function(message) {
  		console.log(message.body);
  });

});

</script>
</body>

</html>