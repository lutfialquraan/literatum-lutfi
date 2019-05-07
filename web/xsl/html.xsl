<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="article">
        <xsl:text>&#xa;</xsl:text>
        <div class="container">
            <xsl:text>&#xa;</xsl:text>
            <xsl:apply-templates select="body/p"/>
        </div>
    </xsl:template>

    <xsl:template match="body/p">

        <p>
            <xsl:value-of select="text()"/>
        </p>
        <xsl:text>&#xa;</xsl:text>
    </xsl:template>

</xsl:stylesheet>
