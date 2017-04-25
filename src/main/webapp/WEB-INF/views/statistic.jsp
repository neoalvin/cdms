<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap-dialog.css">
  <script type="application/javascript" src="js/jquery-3.2.0.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/bootstrap-dialog.js"></script>
  <script type="application/javascript" src="js/chart.js"></script>
  <script type="application/javascript" src="js/statistic.js"></script>
</head>
<body>
  <canvas id="myChart" width="800" height="600"></canvas>
</body>
<script type="text/javascript">
var ctx = document.getElementById("myChart").getContext("2d");
var myNewChart = new Chart(ctx).PolarArea(data);
new Chart(ctx).Bar(data,options);

//数据结构
var data = {
	labels : ["January","February","March","April","May","June","July"],
	datasets : [
		{
			fillColor : "rgba(220,220,220,0.5)",
			strokeColor : "rgba(220,220,220,1)",
			data : [65,59,90,81,56,55,40]
		},
		{
			fillColor : "rgba(151,187,205,0.5)",
			strokeColor : "rgba(151,187,205,1)",
			data : [28,48,40,19,96,27,100]
		}
	]
}
</script>
</html>
