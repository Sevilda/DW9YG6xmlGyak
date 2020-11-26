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
				<h2>Autok</h2>
				Osszes autok szama amik dragabbak mint 30000: <xsl:value-of select="count(autok/auto[ar>30000])"/>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>