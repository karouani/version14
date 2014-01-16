<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="amcharts/style.css" type="text/css">
<script src="amcharts/amcharts.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
            var chart;
            var legend;

            var chartData = [
            
			{
              Dossier : "Dossier N° 1",
               value:   60
            } ,
            {
              Dossier : "Dossier N° 1",
               value:   40
            } ,
            {
              Dossier : "Dossier N° 1",
               value:   10
            } ,
            {
              Dossier : "Dossier N° 1",
               value:   80
            } 
			
			];
			
			
            AmCharts.ready(function () {
                // PIE CHART
                chart = new AmCharts.AmPieChart();
                chart.dataProvider = chartData;
                chart.titleField = "Dossier";
                chart.valueField = "value";
                chart.outlineColor = "#FFFFFF";
                chart.outlineAlpha = 0.8;
                chart.outlineThickness = 2;
                // this makes the chart 3D
                chart.depth3D = 15;
                chart.angle = 30;

                // WRITE
                chart.write("chartdiv");
            });
        </script>
   
        <div id="chartdiv" style="width: 100%; height: 400px;"></div>
   
</body>
</html>