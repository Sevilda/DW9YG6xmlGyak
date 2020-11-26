<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />

	<xsl:template match="orarend">
		<html>
			<head>
				<title> Orarend </title>
			</head>
			<body>
				<h2>valami</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th style="text-align:left">Hetfo</th>
						<th style="text-align:left">Kedd</th>
						<th style="text-align:left">Szerda</th>
						<th style="text-align:left">Csutortok</th>
					</tr>

					<xsl:for-each select="ora">
						<tr>
							<td>
								<xsl:value-of select="targy" />
							</td>

						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
