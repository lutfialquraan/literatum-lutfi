<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="actions">
        <xsl:apply-templates/>
    </xsl:template>

    <!--    <xsl:template match="action">-->
    <!--        <p>-->
    <!--            <xsl:value-of select="@name"/>-->
    <!--        </p>-->
    <!--    </xsl:template>-->

<!--    <xsl:template match="action">-->
<!--        <xsl:value-of select="code"/>-->
<!--    </xsl:template>-->

    <xsl:template match="action">
        <xsl:value-of select="@url"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="@class"/>
    </xsl:template>
</xsl:stylesheet>