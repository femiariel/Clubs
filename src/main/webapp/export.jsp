<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
</head>
<body>
<div id="content">
<h1>Titre</h1>
<p>Contenu de la page</p>
</div>

 

  <button onclick="exportToPDF()">Exporter en PDF</button>

 

  <script>
    function exportToPDF() {
      const doc = new jsPDF();
      const content = document.getElementById("content").innerHTML;
      doc.text(content, 10, 10);
      doc.save("export.pdf");
    }
</script>
</body>
</html>