<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />

	<xsl:template match="/">
		<html>
			<head>
				<title>Autok</title>
			</head>
			<body>
				<h2>Rendszamok, list</h2>
				<table border="1">
					<xsl:for-each select="autok/auto">
						<tr>
							<xsl:value-of select="@rsz" />
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
