<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />

	<xsl:template match="/">
		<xsl:copy>
			<xsl:element name="html">
				<xsl:element name="head">
					<xsl:element name="title">
						Proba
					</xsl:element>
				</xsl:element>
				<xsl:element name="body">
					<xsl:apply-templates select="autok"></xsl:apply-templates>
				</xsl:element>
			</xsl:element>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="autok">
		<xsl:element name="table">
			<xsl:element name="thead">
				<xsl:element name="tr">
					<xsl:element name="td">
						TipusNev
					</xsl:element>
					<xsl:element name="td">
						Tipus darab
					</xsl:element>
				</xsl:element>
			</xsl:element>


			<xsl:for-each-group select="auto" group-by="tipus">
				<xsl:sort select="count(tipus)" order="descending" />
				<xsl:element name="tr">
					<xsl:element name="td">
						<xsl:value-of select="count(tipus)" />
					</xsl:element>
					<xsl:element name="td">
						<xsl:value-of select="tipus" />
					</xsl:element>
				</xsl:element>
			</xsl:for-each-group>
		</xsl:element>


	</xsl:template>

</xsl:stylesheet>