<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="article">
        <xsl:text>&#xa;</xsl:text>
        <xsl:apply-templates select="front/article-meta"/>
    </xsl:template>


    <xsl:template match="front/article-meta">
        <xsl:value-of select="./article-id"/>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select="./article-categories/subj-group/subject"/>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select="./title-group/article-title"/>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select="./contrib-group/contrib/string-name/given-names"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="./contrib-group/contrib/string-name/surname"/>
    </xsl:template>
</xsl:stylesheet>
