<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />

	<xsl:template match="/">
			<html>
			<head>	<title>Autok</title> </head>
			<body>
				<h2>Autok, select</h2>
				<table>
					<tr>
						Autok rendszama, amiknel tulajdonos Miskolci:
					</tr>
					<xsl:for-each select="autok/auto">
						<tr>
							<xsl:if test="tulaj/varos='Miskolc'">
								<xsl:value-of select="@rsz"/>
							</xsl:if>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>