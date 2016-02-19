<html>
<head>
<script src="/logs/resources/js/jquery-2.2.0.min.js"></script>
<script src="/logs/resources/js/stomp.js"></script>
<script src="//cdn.jsdelivr.net/sockjs/1.0.3/sockjs.min.js"></script>
</head>
<body>
<script type="text/javascript">



	$.ajax('/logs/initFile').done(function(data) {
		var socket = new SockJS('/logs/random');
		var client = Stomp.over(socket);

		client.connect({}, function(frame) {

			client.subscribe("/data/"+ data.id, function(message) {
				console.log(message.body);
			});
			
			client.send("/read/file", {}, JSON.stringify({ 'fileName': "D:\\work\\jora.txt", 'sessionId': data.id }));

		});
	})
</script>
</body>

</html>